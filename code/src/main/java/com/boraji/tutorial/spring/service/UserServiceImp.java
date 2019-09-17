package com.boraji.tutorial.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dataeconomy.datamigration.dao.UserDao;
import com.dataeconomy.datamigration.model.User;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public long save(User book) {
      return userDao.save(book);
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
   public void update(long id, User book) {
      userDao.update(id, book);
   }

   @Transactional
   @Override
   public void delete(long id) {
      userDao.delete(id);
   }

}
