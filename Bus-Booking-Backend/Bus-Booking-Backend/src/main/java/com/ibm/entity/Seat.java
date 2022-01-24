package com.ibm.entity;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Seat {
	
	@Id
	@GeneratedValue
	@Column(name = "seat_id")
	private int seat_id;
	@Column(name="seat_no")
	private int seat_no;
	@Column(name = "seat_status", length = 10)
	private String seat_status;//vacant or occupied
	
	@JsonBackReference(value="bus_seat")
	@ManyToOne
	@JoinColumn(name="bus_id")
	private Bus bus;
	
	@JsonBackReference(value="booking_seat")
	@ManyToOne
	@JoinColumn(name="booking_id") 
	private Booking booking;

	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
	public Seat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Seat(int seat_id, int seat_no, String seat_status) {
		super();
		this.seat_id = seat_id;
		this.seat_no = seat_no;
		this.seat_status = seat_status;
	}
	
	public int getSeat_id() {
		return seat_id;
	}
	public void setSeat_id(int seat_id) {
		this.seat_id = seat_id;
	}
	public int getSeat_no() {
		return seat_no;
	}
	public void setSeat_no(int seat_no) {
		this.seat_no = seat_no;
	}
	public String getSeat_status() {
		return seat_status;
	}
	public void setSeat_status(String seat_status) {
		this.seat_status = seat_status;
	}
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	
	
}

