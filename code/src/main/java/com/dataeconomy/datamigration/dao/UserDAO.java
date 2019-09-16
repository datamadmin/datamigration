package com.dataeconomy.datamigration.dao;

import java.util.List;

import com.dataeconomy.datamigration.models.userConfig.User;
import com.dataeconomy.framework.dao.BaseDAO;

public interface UserDAO extends BaseDAO<User, Long> {

	User getUser(String uname);

	boolean uniqueUserEmail(String email);

	boolean uniqueUserName(String userName);

	boolean uniqueUserEmail(String email, String userId);

	void resetpwd(Long userid, String salt, String hash);

	void unlockUser(Long userid);

	void updateUserGroup(Long userId, int groupid);

	List<String> getTaskAccessRights(Integer groupId);

	List<Long> getUsers(Integer groupId);

	List<User> getUsersList(Integer groupId);

	List<String> getUserNames();

	List<User> getUsersList();

	List<String> getAllDGOs();

	boolean checkRoleNameAssigendOrNot(Integer roleId);

	List<User> checkOrgIdAssinedOrNot(List<Long> ids);

	List<User> getUserIdNameByRoleId(Integer roleId);
}
