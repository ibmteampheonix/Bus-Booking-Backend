package com.ibm.entity;

import java.util.ArrayList;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class User {
	@Id
	@Column(name = "email_id", length = 50)
	private String email_id;
	@Column(name = "mobile_no", length = 10)
	private String mobile_no;
	@Column(name = "user_name", length = 30)
	private String user_name;
	@Column(name = "password", length = 30)
	private String password;
	
	@JsonManagedReference(value="user_booking")
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL) 
	private List<Booking> booking = new ArrayList<Booking>();
	
	public User() {
		super();
	}

	public User(String email_id, String mobile_no, String user_name, String password) {
		super();
		this.email_id = email_id;
		this.mobile_no = mobile_no;
		this.user_name = user_name;
		this.password = password;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public List<Booking> getBookings() {
		return booking;
	}

	public void setBookings(List<Booking> bookings) {
		this.booking = bookings;
	}
	
	
}
