//SeatController
package com.ibm.rest;

import java.util.List;


//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.entity.Seat;
import com.ibm.service.SeatService;

@CrossOrigin
@RestController
public class SeatController {

	
	@Autowired
	private SeatService service;
	
	
	@PostMapping(value="/seat/{bus_id}",consumes = {"application/json"})
	public void addSeats(@RequestBody Seat seat,@PathVariable int bus_id) {
		service.addSeat(seat,bus_id);
	}
	
	@PutMapping(value="/seat/{seat_id}/{booking_id}/{status}",consumes = "application/json")
	public void updateAllSeatStatusByBookingId(@PathVariable int seat_id,@PathVariable int booking_id,@PathVariable String status) {
		service.updateAllSeatStatusByBookingId(seat_id,booking_id,status);
	}
	
	@GetMapping(value="/seat/bybooking/{booking_id}",produces = "application/json")
	public List<Seat> findAllseatsBybookingId(@PathVariable int booking_id){
		return service.findAllseatsBybookingId(booking_id);
	}
	
	@GetMapping(value="/seat/sid/{bus_id}",produces = "application/json")
	public List<Seat> findAllseatsBybusId(@PathVariable int bus_id){
		return service.findAllseatsBybusId(bus_id);
	}
}