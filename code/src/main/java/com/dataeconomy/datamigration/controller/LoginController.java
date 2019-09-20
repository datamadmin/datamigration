package com.dataeconomy.datamigration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dataeconomy.datamigration.model.User;
import com.dataeconomy.datamigration.service.UserService;

@RestController
public class LoginController {

	@Autowired
	private UserService userService;

	@PostMapping("/loginuser")
	public boolean loginuser(@RequestBody User user) {
		return userService.checklogin(user.getUserName(),user.getPassword());
	}
	@PostMapping("/resetPassword")
	public void resetPassword(@RequestBody User user) {
		userService.resetPassword(user.getUserName(),user.getPassword());
	}


}