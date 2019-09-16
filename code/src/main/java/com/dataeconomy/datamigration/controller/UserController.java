package com.dataeconomy.datamigration.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dataeconomy.datamigration.models.userConfig.User;
import com.dataeconomy.datamigration.service.UserService;
import com.dataeconomy.framework.errorHandler.AppException;
import com.dataeconomy.framework.util.AppUser;
import com.dataeconomy.framework.util.DateUtils;
import com.dataeconomy.framework.util.PasswordEncryptor;
import com.dataeconomy.framework.util.PasswordGenerator;
import com.dataeconomy.framework.util.ThreadLocalUtil;
import com.dataeconomy.workbench.constant.MessagesEnum;
import com.dataeconomy.workbench.constant.UserStatus;

@RestController
@RequestMapping("/api/user")

public class UserController {

	@Autowired
	UserService userService;

	@Resource(name = "tokenServices")
	ConsumerTokenServices tokenServices;

	/*
	 * *Get All user list
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public AppUser getUser() {
		AppUser user = ThreadLocalUtil.getUser();
		return user;
	}

	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> findAll() {
		return userService.findAll();
	}

	@RequestMapping(value = "/getUserByid/{userId}", method = RequestMethod.GET)
	public User getUserByid(@PathVariable("userId") Long userId) {
		return userService.findOne(userId);
	}

	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public void createUser(@RequestBody User user) {
		if (userService.uniqueUserName(user.getUserName())) {
			throw new AppException(MessagesEnum.LOGIN_NAME_ALREADY_EXISTS);
		} else {
			user.setUserStatus(UserStatus.USER_FIRST_LOGIN.value);
			String password = String.valueOf(PasswordGenerator.generatePassword());
			String salt = PasswordEncryptor.generateSalt();
			String hash = PasswordEncryptor.applySHA256(password + salt);
			user.setUserSalt(salt);
			user.setPasswordHash(hash);
			user.setPasswordExpirationDate(DateUtils.getPasswordExpirationDate());
			user.setCreatedBy(ThreadLocalUtil.getUserName());
			userService.create(user);
			
		}
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public void updateUser(@RequestBody User user) {
		// TODO need to add @JsonIgnore
		User dbUser = userService.getUser(user.getUserName());
		if (dbUser != null && !dbUser.getUserId().equals(user.getUserId())) {
			throw new AppException(MessagesEnum.LOGIN_NAME_ALREADY_EXISTS);
		} else {
			User existingUser = userService.findOne(user.getUserId());
			existingUser.setUserName(user.getUserName());
			existingUser.setFirstName(user.getFirstName());
			existingUser.setLastName(user.getLastName());
			existingUser.setUserEmail(user.getUserEmail());
			existingUser.setUserStatus(user.getUserStatus());
			existingUser.setCreateTask(user.isCreateTask());
			existingUser.setRoleId(user.getRoleId());
			existingUser.setOrgId(user.getOrgId());
			userService.updateUser(existingUser);
		}
	}

	@RequestMapping(value = "/unlockUsers", method = RequestMethod.POST)
	public void unlockUsers(@RequestBody List<Long> selectedUserIdList) {
		List<Long> userIdList = new ArrayList<Long>();
		for (Long userId : selectedUserIdList) {
			User user = userService.findOne(userId);
			if (user.getUserStatus().equals(UserStatus.USER_LOCKED.value)) {
				userIdList.add(userId);
			}
		}
	}

	@RequestMapping(value = "/lockUser", method = RequestMethod.POST)
	public void lockUsers(@RequestBody Long userId) {
		User user = userService.findOne(userId);
		user.setUserStatus(UserStatus.USER_LOCKED.value);
		userService.update(user);
		userService.deleteOauthToken(user.getUserName());
	}

	@RequestMapping(value = "/deleteUsers", method = RequestMethod.POST)
	public void deleteUsers(@RequestBody List<Long> selectedUserIdList) {
		userService.deleteUsers(selectedUserIdList);
	}

	@RequestMapping(value = "/deleteSingleUser/{userId}", method = RequestMethod.GET)
	public void deleteSingleUser(@PathVariable("userId") Long userId) {
		userService.deleteSingleUser(userId);
	}

	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	public void resetpassword(@RequestBody List<Long> selectedUserIdList) throws AddressException, MessagingException {
		userService.resetPasswords(selectedUserIdList);
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void logout(@RequestBody Map<String, String> token) {
		String tokenId = token.get("access_token");
		tokenServices.revokeToken(tokenId);
	}

	@RequestMapping(value = "/changePwd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void resetPwdButton(@RequestBody Map<String, Object> userDetails)
			throws AddressException, MessagingException {
		userService.resetpwd(ThreadLocalUtil.getUserId(), (String) userDetails.get("newPassword"));
	}

	@RequestMapping(value = "/renewalPwd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void renewalPwd(@RequestBody Map<String, Object> userDetails) throws AddressException, MessagingException {
		String oldPassword = (String) userDetails.get("oldPassword");
		String newPassword = (String) userDetails.get("newPassword");
		Long userId = ThreadLocalUtil.getUserId();
		if (userService.isValidPassword(userId, oldPassword)) {
			userService.resetpwd(userId, newPassword);
		} else {
			throw new AppException(MessagesEnum.INVALID_OLD_PASSWORD);
		}
	}
}
