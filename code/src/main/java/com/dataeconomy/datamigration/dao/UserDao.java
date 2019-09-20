package com.dataeconomy.datamigration.dao;

import java.util.List;

import com.dataeconomy.datamigration.model.User;

public interface UserDao{

	long save(User user);

	User get(long id);

	List<User> list();

	void update(long id, User user);

	void delete(long id);
	boolean checklogin(String username,String password);
	User getSelectedUser(String username);
}
