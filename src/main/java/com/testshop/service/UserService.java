package com.testshop.service;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.testshop.domain.User;
import com.testshop.domain.UserRole;
import com.testshop.domain.supply.Contact;
import com.testshop.domain.supply.Role;
import com.testshop.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Transactional
	public boolean registration(String name, String password, String email, String phone, String street) {
		
		if(isPresent(name))
			return false;
		
		User user = new User();
		
		user.setUsername(name);
		//user.setPassword(bCryptPasswordEncoder.encode(password));
		user.setPassword(password);
		user.setEnabled(true);
		
		Contact contact = new Contact();
		contact.setEmail(email);
		contact.setPhone(phone);
		contact.setStreet(street);
		
		user.setContact(contact);

		
		Set<UserRole> userRole = user.getUserRole();
		UserRole ur = new UserRole();
		ur.setUser(user);
		ur.setRole(Role.ROLE_USER);
		userRole.add(ur);
		
		
		userRepository.save(user);
		
		return true;
	}
	
	@Transactional
	public boolean registration(String name, String password, Role role) {
		
		if(isPresent(name))
			return false;
		
		User user = new User();
		
		user.setUsername(name);
		//user.setPassword(bCryptPasswordEncoder.encode(password));
		user.setPassword(password);
		user.setEnabled(true);

		
		Set<UserRole> userRole = user.getUserRole();
		UserRole ur = new UserRole();
		ur.setUser(user);
		ur.setRole(role);
		userRole.add(ur);
		
		
		userRepository.save(user);
		
		return true;
	}
	
	@Transactional
	public void delete(String name) {
		User user = userRepository.findOne(name);
		user.setUserRole(null);
		userRepository.delete(name);
	}
	
	@Transactional
	public boolean isPresent(String id) {		
		return userRepository.exists(id);
	}
	
	@Transactional
	public User getCurrentUser() {		 
		 UserDetails userDetails = (UserDetails) org.springframework.security.core.context.SecurityContextHolder
	                .getContext().getAuthentication().getPrincipal();
		 String userName = userDetails.getUsername();
		 User user = userRepository.findOne(userName);
		 
		 return user;
	}
	
}
