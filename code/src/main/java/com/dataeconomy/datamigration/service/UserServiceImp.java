package com.dataeconomy.datamigration.service;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dataeconomy.datamigration.dao.UserDao;
import com.dataeconomy.datamigration.model.User;
import com.dataeconomy.datamigration.utils.RandomUtil;
import com.dataeconomy.datamigration.utils.MailUtil;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

	@Autowired
	private UserDao userDao;

	@Transactional
	@Override
	public long save(User user)  {
		user.setPassword(RandomUtil.getRandomPassword());
		try {
			MailUtil.sendUseralert(user.getUserName(), user.getEmailid(), user.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}
		user.setPassword(Base64.getEncoder().encodeToString(user.getPassword().getBytes()));
		return userDao.save(user);
	}

	@Override
	public User get(long id) {
		return userDao.get(id);
	}

	@Override
	public List<User> list() {
		return userDao.list();
	}

	@Transactional
	@Override
	public void update(long id, User user) {
		userDao.update(id, user);
	}

	@Transactional
	@Override
	public void delete(long id) {
		userDao.delete(id);
	}
	@Transactional
	@Override
	public boolean checklogin(String username,String password)
	{
		return userDao.checklogin(username,new String(Base64.getDecoder().decode(password)));
	}
	@Transactional
	@Override
	public void resetPassword(String username,String password) 
	{
		User usr = userDao.getSelectedUser(username);
		usr.setPassword(Base64.getEncoder().encodeToString(password.getBytes()));
		userDao.update(usr.getId(), usr);
	}
}
