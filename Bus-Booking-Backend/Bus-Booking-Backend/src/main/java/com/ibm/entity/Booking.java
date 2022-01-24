
package com.ibm.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
//import java.util.ArrayList;
//import java.util.List;
//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

//import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Booking {

		@Id
		@GeneratedValue
		@Column(name = "booking_id")
		private int booking_id;
		@Column(name = "booking_status", length = 10)
		private String booking_status;//cancel or book
		
		
		@JsonManagedReference(value="booking_seat")
		@OneToMany(mappedBy = "booking",cascade = CascadeType.ALL)
		private List<Seat> seat = new ArrayList<Seat>();
		
		
		@JsonBackReference(value="user_booking")
		@ManyToOne
		@JoinColumn(name="email_id")
		private User user;
		
		/*
		@JsonBackReference(value="bus_booking")
		@ManyToOne
		@JoinColumn(name="bus_id")
		private Bus bus;
		*/
		
		public Booking() {
			super();
			
		}

		public Booking(int booking_id, String booking_status) {
			super();
			this.booking_id = booking_id;
			this.booking_status = booking_status;
		}
		public int getBooking_id() {
			return booking_id;
		}
		public void setBooking_id(int booking_id) {
			this.booking_id = booking_id;
		}
		public String getBooking_status() {
			return booking_status;
		}
		public void setBooking_status(String booking_status) {
			this.booking_status = booking_status;
		}
		
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public List<Seat> getSeat() {
			return seat;
		}

		public void setSeat(List<Seat> seat) {
			this.seat = seat;
		}
		
		/*
		public Bus getBus() {
			return bus;
		}

		public void setBus(Bus bus) {
			this.bus = bus;
		}*/

}

