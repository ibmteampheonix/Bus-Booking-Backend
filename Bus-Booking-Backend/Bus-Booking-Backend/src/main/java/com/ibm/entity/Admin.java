package com.ibm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {
	@Id
	@Column(name="admin_email",length=50)
	private String email_id;
	@Column(name="admin_password",length=30)
	private String password;

	public Admin() {
		super();
	}

	public Admin(String email_id, String password) {
		super();
		this.email_id = email_id;
		this.password = password;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
