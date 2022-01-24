package com.ibm.service;

public class LoginService {

	private String email_id;
	
	private String password;

	public LoginService(String email_id, String password) {
		this.email_id = email_id;
		this.password = password;
	}

	public LoginService() {
	}

	public String getEmail() {
		return email_id;
	}

	public void setEmail(String email_id) {
		this.email_id = email_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
