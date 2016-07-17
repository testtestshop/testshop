package com.testshop.controller;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.testshop.domain.User;
import com.testshop.domain.UserRole;
import com.testshop.repository.UserRepository;
import com.testshop.service.UserService;

@Controller
@RequestMapping(value = "/api/user")
public class UserController implements RestController<User> {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@Override
	public String get(@PathVariable String id, Model model) {
		model.addAttribute("user", userRepository.findOne(id));
		return "user/user";
	}

	@RequestMapping(method = RequestMethod.GET)
	@Override
	public String getAll(Model model) {
		model.addAttribute("users", (List<User>) userRepository.findAll());
		return "user/userList";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@Override
	public String add(@ModelAttribute("user") User input) {
	
		userRepository.save(input);
		
		return "redirect:/api/user";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@Override
	public String update(@PathVariable String id, @ModelAttribute User input) {
		input.setUsername(id);
		userRepository.save(input);
		
		return "redirect:/api/user";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@Override
	public String delete(@PathVariable String id) {
		userRepository.delete(id);
		
		return "redirect:/api/user";
	}

	@RequestMapping(method = RequestMethod.DELETE)
	@Override
	public String deleteAll() {
		userRepository.deleteAll();
		
		return "redirect:/api/user";
	}
	
}
