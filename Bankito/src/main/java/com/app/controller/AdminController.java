package com.app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.BusinessException.BussinessException;
import com.app.model.Admin;

@RestController
@CrossOrigin
public class AdminController {
	static String Email = "Bankito@gmail.com";
	static String Password = "Bankito@333";

	@PostMapping("/admin/login")
	public Admin adminLogin(@RequestBody Admin admin) {
		boolean flag = false;
		if (Email.equals(admin.getEmail()) && Password.equals(admin.getPassword())) {
			flag = true;
		}

		if (flag) {
			return admin;
		} else {
			throw new BussinessException("Invalid login,retry");
		}
	}
}