package com.dataeconomy.datamigration.service;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dataeconomy.datamigration.dao.UserDao;
import com.dataeconomy.datamigration.model.User;
import com.dataeconomy.datamigration.utils.RandomUtil;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public long save(User user) {
	   user.setPassword(RandomUtil.getRandomPassword());
	   user.setPassword(Base64.getEncoder() 
               .encodeToString(user.getPassword().getBytes()));
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

}
