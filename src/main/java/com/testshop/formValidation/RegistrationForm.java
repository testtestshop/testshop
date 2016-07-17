package com.testshop.formValidation;

import org.hibernate.validator.constraints.*;

public class RegistrationForm {
	
	@Length(min=5, max=30, message = "name length should be between 5 and 30")
	private String username;
	@Length(min=16, max=30, message = "name length should be between 16 and 30")
	private String password;
	
	@Email(message = "incorrect email")
	private String email;
	
	@Length(min = 5, max = 1000, message = "something wrong")
	private String street;
	
	@Length(min = 5, max = 50, message = "something wrong")
	private String phone;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
