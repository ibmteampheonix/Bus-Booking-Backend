package com.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ibm.entity.Seat;
import com.ibm.repo.BookingRepository;
import com.ibm.repo.BusRepository;
import com.ibm.repo.SeatRepository;

@Service
public class SeatServiceImpl implements SeatService {
	
	@Autowired
	private SeatRepository seat_repo;
	
	@Autowired
	private BookingRepository booking_repo;
	
	@Autowired
	private BusRepository repo;
	
	@Override
	public void addSeat(Seat seat, int bus_id) {
		seat.setBus(repo.findById(bus_id).get());
		seat_repo.save(seat);
	}

	@Override
	public void updateAllSeatStatusByBookingId(int seat_id, int booking_id, String status) {
		Seat seat=seat_repo.findById(seat_id).get();
		seat.setBooking(booking_repo.findById(booking_id).get());
		/*
		if(bookingId==0)
		{
			seat.setBooking(null);
		}
		else
			seat.setBooking(bookRepo.findById(bookingId).get());
		*/
		seat.setSeat_status(status);
		seat_repo.save(seat);
		
	}

	@Override
	public List<Seat> findAllseatsBybookingId(int booking_id) {
		return seat_repo.findAllSeatsByBookingId(booking_id);
	}

	@Override
	public List<Seat> findAllseatsBybusId(int bus_id) {
		return seat_repo.findAllSeatsByBusId(bus_id);
	}

}
