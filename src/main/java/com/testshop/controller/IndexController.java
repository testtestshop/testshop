package com.testshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.testshop.domain.User;
import com.testshop.domain.UserRole;
import com.testshop.service.UserService;

@Controller
public class IndexController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = {"/", "/index"},  method = RequestMethod.GET)
	public String index() {
		return "redirect:/api/item";
	}
	
}
