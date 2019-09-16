package com.dataeconomy.datamigration.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dataeconomy.datamigration.dao.OauthAccessTokenDAO;
import com.dataeconomy.datamigration.dao.UserDAO;
import com.dataeconomy.datamigration.models.userConfig.User;
import com.dataeconomy.framework.errorHandler.AppException;
import com.dataeconomy.framework.util.AppUser;
import com.dataeconomy.framework.util.DateUtils;
import com.dataeconomy.framework.util.PasswordEncryptor;
import com.dataeconomy.framework.util.PasswordGenerator;
import com.dataeconomy.framework.util.ThreadLocalUtil;
import com.dataeconomy.workbench.constant.MessagesEnum;
import com.dataeconomy.workbench.constant.UserStatus;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;

	@Autowired
	OauthAccessTokenDAO oAuthAccessTokenDAO;


	

	@Transactional(readOnly = true)
	public List<User> findAll() {
		List<User> users = userDAO.findAll();
		return users;
	}

	@Transactional
	public void create(User user) {
		userDAO.create(user);
	}

	@Transactional
	public void update(User user) {
		userDAO.update(user);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean uniqueUserEmail(String email) {
		return userDAO.uniqueUserEmail(email);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean uniqueUserEmail(String email, String userId) {
		return userDAO.uniqueUserEmail(email, userId);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean uniqueUserName(String userName) {
		return userDAO.uniqueUserName(userName);
	}

	@Transactional
	public AppUser getUserForLogin(String userNameOrEmail, String password) {
		User user = userDAO.getUser(userNameOrEmail);
		
		LocalDateTime expDate = null;
		LocalDateTime currentDate = null;
		Long diffDays=0l;
			try {
				expDate = user.getPasswordExpirationDate();
				currentDate = DateUtils.getCurrentUTCDateTime();
				diffDays=currentDate.until(expDate, ChronoUnit.DAYS);
			
			} catch (Exception e) {
				e.printStackTrace();
			}
				
		if (user == null) {
			throw new AppException(MessagesEnum.INVALIDUSER_MSG);
		} else {
			int loginAttemptCount = user.getLoginAttempts();
			if (isValidPassword(user, password)) {
				if (!hasExceededLoginAttempts(user)) {
					loginAttemptCount = 0;
				}
				if (user.hasPasswordExpired()) {
					user.setUserStatus(Integer.valueOf(UserStatus.USER_EXPIRED.value));
					user.setLoginAttempts(loginAttemptCount);
					ThreadLocalUtil.setThreadVariable(ThreadLocalUtil.USER_NAME, user.getUserName());
					userDAO.update(user);
					return new AppUser(user);
				} else if (user.getUserStatus().equals(Integer.valueOf(UserStatus.USER_DISABLED.value))) {
					throw new AppException(MessagesEnum.USER_DISABLED_MSG, user.getUserName());
				} else if (user.getUserStatus().equals(Integer.valueOf(UserStatus.USER_LOCKED.value))) {
					throw new AppException(MessagesEnum.USER_LOCKED_MSG, user.getUserName());
				} else if (user.getUserStatus().equals(Integer.valueOf(UserStatus.USER_INACTIVE.value))) {
					throw new AppException(MessagesEnum.USER_INACTIVE, user.getUserName());
				}
				user.setLoginAttempts(loginAttemptCount);
				user.setLastLoginDate(DateUtils.getCurrentUTCDateTime());
				ThreadLocalUtil.setThreadVariable(ThreadLocalUtil.USER_NAME, user.getUserName());
				user = userDAO.update(user);
				oAuthAccessTokenDAO.deleteOauthTokenName(user.getUserName());
			} else {
				if (user.getUserStatus().equals(Integer.valueOf(UserStatus.USER_LOCKED.value))) {
					throw new AppException(MessagesEnum.USER_LOCKED_MSG, user.getUserName());
				}
				++loginAttemptCount;
				if (loginAttemptCount >= 3) {
					user.setUserStatus(UserStatus.USER_LOCKED.value);
					user.setLoginAttempts(loginAttemptCount);
					ThreadLocalUtil.setThreadVariable(ThreadLocalUtil.USER_NAME, user.getUserName());
					user = userDAO.update(user);
					AppUser appuser = new AppUser(user);
					appuser.setUserLocked("UserLocked");
					return appuser;
				}
				user.setLoginAttempts(loginAttemptCount);
				ThreadLocalUtil.setThreadVariable(ThreadLocalUtil.USER_NAME, user.getUserName());
				user = userDAO.update(user);
				AppUser appuser = new AppUser(user);
				int count = 3-loginAttemptCount;
				appuser.setLoginCount(count);
				return appuser;
				
			}
		}
		AppUser appuser = new AppUser(user);
		if (user.getGroupid() != null) {

		}
		appuser.setExpiryDays(diffDays);
		return appuser;
	}


	public boolean isValidPassword(User user, String password) {
		return PasswordEncryptor.isValidPassword(password + user.getUserSalt(), user.getPasswordHash());
	}

	@Override
	public boolean isValidPassword(Long userId, String password) {
		User user = userDAO.findOne(userId);
		return PasswordEncryptor.isValidPassword(password + user.getUserSalt(), user.getPasswordHash());
	}

	private boolean hasExceededLoginAttempts(User user) {
		return user.getLoginAttempts() >= 3;
	}

	@Transactional(readOnly = true)
	public User getUser(String email) {
		return userDAO.getUser(email);
	}

	@Transactional
	public User forgotPassword(User user, String password) {
		if (user != null) {
			if ((user.getUserStatus().equals(Integer.valueOf(UserStatus.USER_LOCKED.value)))) {
				throw new AppException(MessagesEnum.UNABLE_RESET_PASSWORD, user.getUserName());
			} else {
				String salt = PasswordEncryptor.generateSalt();
				String hash = PasswordEncryptor.applySHA256(password + salt);
				user.setUserSalt(salt);
				user.setPasswordHash(hash);
				user.setUserStatus(UserStatus.USER_FIRST_LOGIN.value);
				user.setLoginAttempts(0);
				user.setPasswordExpirationDate(DateUtils.getPasswordExpirationDate());
				return userDAO.update(user);
			}
		} else {
			return null;
		}

	}

	@Transactional
	public void resetpwd(Long userid, String password) throws AddressException, MessagingException {
		User user = userDAO.findOne(userid);
		if ((user.getUserStatus().equals(Integer.valueOf(UserStatus.USER_LOCKED.value)))) {
			throw new AppException(MessagesEnum.UNABLE_RESET_PASSWORD, user.getUserName());
		} else {
			String salt = PasswordEncryptor.generateSalt();
			String hash = PasswordEncryptor.applySHA256(password + salt);
			user.setUserSalt(salt);
			user.setPasswordHash(hash);
			user.setUserStatus(UserStatus.USER_ENABLED.value);
			user.setLoginAttempts(0);
			user.setLastLoginDate(DateUtils.getCurrentUTCDateTime());
			user.setPasswordExpirationDate(DateUtils.getPasswordExpirationDate());
			userDAO.update(user);
		}
	}


	@Transactional
	public void unlockUsers(String userIds[]) {
		for (String unlockid : userIds) {

			userDAO.unlockUser(Long.parseLong(unlockid));
		}
	}

	@Transactional
	public void resetPasswords(List<Long> userIds) throws AddressException, MessagingException {
		for (Long uid : userIds) {
			resetpwd(uid, String.valueOf(PasswordGenerator.generatePassword()));
			User user = userDAO.findOne(uid);
			user.setUserStatus(UserStatus.USER_FIRST_LOGIN.value);
			user.setLoginAttempts(0);
			userDAO.update(user);
		}

	}

	@Transactional
	public void updateUserGroup(Long userId, int groupid) {
		userDAO.updateUserGroup(userId, groupid);
	}

	@Transactional
	public List<String> getTaskAccessRights(Integer groupId) {
		List<String> taskAccessRigts = new ArrayList<String>();
		taskAccessRigts = userDAO.getTaskAccessRights(groupId);
		return taskAccessRigts;
	}

	@Transactional
	public void updateUser(User user) {
		if (user.getUserStatus().equals(UserStatus.USER_LOCKED.value)) {
			user.setLoginAttempts(3);
			user.setUserStatus(UserStatus.USER_LOCKED.value);
		} else {
			if (user.getUserStatus() != UserStatus.USER_FIRST_LOGIN.value) {
				user.setLoginAttempts(0);
				user.setUserStatus(UserStatus.USER_ENABLED.value);
			}
		}
		userDAO.update(user);
	}

	@Transactional
	public List<Long> getUsers(Integer groupId) {
		return userDAO.getUsers(groupId);
	}

	@Override
	@Transactional
	public void deleteUser(User userId) {
		
		userDAO.delete(userId);
	}

	@Override
	@Transactional(readOnly = true)
	public User findOne(Long id) {
		User us = new User();
		us = userDAO.findOne(id);
				return us;
	}

	@Transactional
	public void usersGroupUpdate(List<Long> userIds, Integer groupId) {
		List<User> users = userDAO.getUsersList(groupId);
		for (User user : users) {
			if (!userIds.contains(user.getUserId())) {
				user.setGroupid(null);
				userDAO.update(user);
			}
		}
		for (Long userId : userIds) {
			boolean newGroup = true;
			for (User user : users) {
				if (user.getUserId().equals(userId)) {
					newGroup = false;
					break;
				}
			}
			if (newGroup) {
				User user = userDAO.findOne(userId);
				user.setGroupid(groupId);
				userDAO.update(user);
			}
		}
	}

	public List<String> getUserNames() {
		return userDAO.getUserNames();
	}

	@Transactional
	public void updateUserStatus(User user) {
		userDAO.update(user);
	}

	@Override
	@Transactional
	public void deleteUsers(List<Long> selectedUserIdList) {
		for (Long userId : selectedUserIdList) {
			User user = userDAO.findOne(userId);
			userDAO.delete(user);
		}
	}

	@Transactional
	public void deleteSingleUser(Long userId) {
		User user = userDAO.findOne(userId);
		userDAO.delete(user);
		 deleteOauthToken(user.getUserName());

	}


	@Transactional
	public void deleteOauthToken(String userName){
	oAuthAccessTokenDAO.deleteOauthTokenName(userName);
	}

}
