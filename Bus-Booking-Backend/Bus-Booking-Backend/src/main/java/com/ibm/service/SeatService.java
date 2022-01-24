package com.ibm.service;

import java.util.List;

import com.ibm.entity.Seat;

public interface SeatService {
	
	void addSeat(Seat seat, int bus_id);

	void updateAllSeatStatusByBookingId(int seat_id, int booking_id, String status);

	List<Seat> findAllseatsBybookingId(int booking_id);

	List<Seat> findAllseatsBybusId(int bus_id);
	
}
