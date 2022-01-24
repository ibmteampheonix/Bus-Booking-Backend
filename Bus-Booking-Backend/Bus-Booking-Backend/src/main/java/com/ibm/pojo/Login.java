package com.ibm.pojo;

public class Login {
	
	private String email_id;
	
	private String password;

	public Login(String email_id, String password) {
		super();
		this.email_id = email_id;
		this.password = password;
	}

	public Login() {
		super();
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email) {
		this.email_id = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
