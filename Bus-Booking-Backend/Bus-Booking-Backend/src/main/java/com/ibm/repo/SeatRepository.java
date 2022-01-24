package com.ibm.repo;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ibm.entity.Seat;
//import com.ibm.entity.User;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
	
	@Query(value="select * from seat where bus_id=:bus_id",nativeQuery = true)
	List<Seat> findAllSeatsByBusId(@Param("bus_id") int bus_id);
	
	@Query(value="select * from seat where seat_no=:seat_no",nativeQuery = true)
	List<Seat> findSeatByNo(@Param("seat_no") int seat_no);

	@Query(value="select * from seat where booking_id=:booking_id",nativeQuery = true)
	List<Seat> findAllSeatsByBookingId(int booking_id);

}
