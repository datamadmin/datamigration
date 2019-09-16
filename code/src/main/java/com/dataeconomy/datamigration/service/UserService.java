package com.dataeconomy.datamigration.service;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.dataeconomy.datamigration.models.userConfig.User;
import com.dataeconomy.framework.util.AppUser;

public interface UserService {

	List<User> findAll();

	void create(User user);

	void update(User user);

	boolean uniqueUserEmail(String email);

	boolean uniqueUserEmail(String email, String userId);

	boolean uniqueUserName(String userName);

	AppUser getUserForLogin(String userNameOrEmail, String password);

	User getUser(String email);

	void resetpwd(Long userid, String password) throws AddressException, MessagingException;

	User forgotPassword(User user, String password);


	void unlockUsers(String userId[]);

	void updateUserGroup(Long userId, int groupid);


	void resetPasswords(List<Long> userId) throws AddressException, MessagingException;


	void updateUser(User user);

	List<Long> getUsers(Integer groupId);

	void usersGroupUpdate(List<Long> userIds, Integer groupId);

	void deleteUser(User userId);

	User findOne(Long id);

	List<String> getUserNames();

	void updateUserStatus(User user);

	void deleteUsers(List<Long> selectedUserIdList);

	boolean isValidPassword(Long userId, String password);

	void deleteSingleUser(Long UserId);

	void deleteOauthToken(String userName);
}
