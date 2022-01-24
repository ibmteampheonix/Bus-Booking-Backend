package com.ibm.service;

import java.util.List;


//import org.springframework.data.repository.query.Param;

import com.ibm.entity.Booking;

public interface BookingService {
	
	void addBooking(Booking booking,String email_id);
	
	List<Booking> findAllByemailId(String email_id);

	void updateStatusByBookingId(int booking_id);
}
