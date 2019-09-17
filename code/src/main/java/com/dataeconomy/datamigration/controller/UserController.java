package com.dataeconomy.datamigration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dataeconomy.datamigration.model.User;
import com.dataeconomy.datamigration.service.UserService;

@RestController
public class UserController {

   @Autowired
   private UserService userService;

   @PostMapping("/getUsers")
   public ResponseEntity<?> save(@RequestBody User user) {
      long id = userService.save(user);
      return ResponseEntity.ok().body("New user has been saved with ID:" + id);
   }

   @GetMapping("/user/{id}")
   public ResponseEntity<User> get(@PathVariable("id") long id) {
      User user = userService.get(id);
      return ResponseEntity.ok().body(user);
   }

   @GetMapping("/getUsers")
   public ResponseEntity<List<User>> list() {
      List<User> users = userService.list();
      return ResponseEntity.ok().body(users);
   }

   @PutMapping("/user/{id}")
   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody User user) {
      userService.update(id, user);
      return ResponseEntity.ok().body("user has been updated successfully.");
   }

   @DeleteMapping("/user/{id}")
   public ResponseEntity<?> delete(@PathVariable("id") long id) {
      userService.delete(id);
      return ResponseEntity.ok().body("user has been deleted successfully.");
   }
}