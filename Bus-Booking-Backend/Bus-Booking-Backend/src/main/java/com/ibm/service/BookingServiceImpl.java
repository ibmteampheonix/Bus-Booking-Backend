package com.ibm.service;

//import java.time.LocalDate;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.Booking;
import com.ibm.entity.Seat;
import com.ibm.repo.BookingRepository;
//import com.ibm.repo.BusRepository;
import com.ibm.repo.SeatRepository;
import com.ibm.repo.UserRepository;


@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private BookingRepository repo;
	
	@Autowired
	private UserRepository user_repo;
	
	@Override
	public void addBooking(Booking booking, String email_id) {
		booking.setUser(user_repo.findUserById(email_id));
		repo.save(booking);
		
	}

	@Override
	public List<Booking> findAllByemailId(String email_id) {
		return repo.findAllByemailId(email_id);
	}

	@Override
	public void updateStatusByBookingId(int booking_id) {
		Booking booking=repo.findById(booking_id).get();
		booking.setBooking_status("Cancelled");
		repo.save(booking);
	}
	
	/*
	@Override
	public void updateBooking(int bookingId) {
		Booking b=repo.findById(bookingId).get();
		b.setCancelDate(LocalDate.now());
		b.setStatusBooking("cancel");
		repo.save(b);
		
	}*/


}
