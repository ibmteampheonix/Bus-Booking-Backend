package com.ibm.entity;

//import java.util.ArrayList;
//import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Bus {
	
	@Id
	@GeneratedValue
	@Column(name="bus_id")
	private int bus_id;
	@Column(name="start_time")
	private LocalTime start_time;
	@Column(name="end_time")
	private LocalTime end_time;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="route_id")
	private Route route;
	
	@JsonManagedReference(value="bus_seat")
	@OneToMany(mappedBy = "bus", cascade = CascadeType.ALL)
	private List<Seat> seat = new ArrayList<Seat>();
	/*
	@JsonManagedReference(value="bus_booking")
	@OneToMany(mappedBy = "bus", cascade = CascadeType.ALL)
	private List<Booking> booking = new ArrayList<Booking>();
	*/

	
	public Bus() {
	}

	public Bus(int bus_id, LocalTime start_time,LocalTime end_time) {
		this.bus_id = bus_id;
		this.start_time = start_time;
		this.end_time = end_time;
	}
	
	

	public int getBus_id() {
		return bus_id;
	}

	public void setBus_id(int bus_id) {
		this.bus_id = bus_id;
	}

	public LocalTime getStart_time() {
		return start_time;
	}

	public void setStart_time(LocalTime start_time) {
		this.start_time = start_time;
	}

	public LocalTime getEnd_time() {
		return end_time;
	}

	public void setEnd_time(LocalTime end_time) {
		this.end_time = end_time;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public List<Seat> getSeat() {
		return seat;
	}

	public void setSeat(List<Seat> seat) {
		this.seat = seat;
	}
	/*
	public List<Booking> getBooking() {
		return booking;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}
	*/
	
}
