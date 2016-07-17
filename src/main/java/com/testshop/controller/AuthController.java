package com.testshop.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.testshop.domain.UserRole;
import com.testshop.domain.supply.Role;
import com.testshop.formValidation.RegistrationForm;
import com.testshop.service.UserService;

@Controller
@RequestMapping(value = "/api/login")
public class AuthController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("registrationForm", new RegistrationForm());
		return "registration";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String add(Model model, @Valid @ModelAttribute("registrationForm") RegistrationForm registrationForm,
			Errors errors) {

		if (errors.hasErrors()) {
			return "registration";
		}

		userService.registration(registrationForm.getUsername(), registrationForm.getPassword(),
				registrationForm.getEmail(), registrationForm.getPhone(), registrationForm.getStreet());

		return "redirect:/api/item";
	}

	@RequestMapping(value = "error", method = RequestMethod.GET)
	public String error() {
		return "registration";
	}

}
