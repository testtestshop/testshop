package com.testshop.domain.supply;

import javax.persistence.Embeddable;
import javax.persistence.Lob;

@Embeddable
public class Contact {
	@Lob
	private String street;
	private String phone;
	@Lob
	private String email;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
