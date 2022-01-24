package com.ibm.entity;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="route")
public class Route {
		@Id
		@GeneratedValue
		@Column(name = "route_id")
		private int route_id;
		@Column(name = "start_point", length = 50)
		private String start_point;
		@Column(name = "end_point", length = 50)
		private String end_point;
		
		
		@JsonManagedReference
		@OneToMany(mappedBy = "route", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		private List<Bus> bus = new ArrayList<Bus>();

		public Route() {
			super();
		}

		public List<Bus> getBus() {
			return bus;
		}

		public void setBus(List<Bus> bus) {
			this.bus = bus;
		}

		public Route(int route_id, String start_point, String end_point) {
			this.route_id = route_id;
			this.start_point = start_point;
			this.end_point = end_point;
		}

		public int getRoute_id() {
			return route_id;
		}

		public void setRoute_id(int route_id) {
			this.route_id = route_id;
		}

		public String getStart_point() {
			return start_point;
		}

		public void setStart_point(String start_point) {
			this.start_point = start_point;
		}

		public String getEnd_point() {
			return end_point;
		}

		public void setEnd_point(String end_point) {
			this.end_point = end_point;
		}
		

}
