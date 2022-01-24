
package com.ibm.rest;

import java.util.List;

//import java.time.LocalTime;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.entity.Booking;
import com.ibm.service.BookingService;
import com.ibm.service.EmailService;


@CrossOrigin
@RestController
public class BookingController {

	
	@Autowired
	private BookingService service;
	
	@Autowired
	private EmailService mail_service;
	
	@PostMapping(value="/booking/{email_id}",consumes = {"application/json"})
	public void addBooking(@RequestBody Booking booking,@PathVariable String email_id) {
		service.addBooking(booking, email_id);
		mail_service.confirmedBooking(email_id, booking.getBooking_id());
	}
	
	@PutMapping(value="/booking/{booking_id}/{email_id}",consumes = "application/json")
	public void updateStatusByBookingId(@PathVariable int booking_id,@PathVariable String status,@PathVariable String email_id) {
		service.updateStatusByBookingId(booking_id);
		mail_service.cancelledBooking(email_id, booking_id);
	}
	
	@GetMapping(value ="/booking/all/{email_id}",produces = "application/json")
	public List<Booking> findAllByemailId(String email_id){
		return service.findAllByemailId(email_id);
	}
}	