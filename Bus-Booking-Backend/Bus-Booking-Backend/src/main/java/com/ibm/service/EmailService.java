package com.ibm.service;


public interface EmailService {
	
	void confirmedBooking(String email_id, int booking_id);
	
	void cancelledBooking(String email_id, int booking_id);

	void emailRegistered(String emailId,String username);
}
