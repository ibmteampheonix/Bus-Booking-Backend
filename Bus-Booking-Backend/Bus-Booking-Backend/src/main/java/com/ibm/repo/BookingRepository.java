package com.ibm.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ibm.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
	
	@Query(value="select * from booking where email_id=:email_id",nativeQuery = true)
	List<Booking> findAllByemailId(@Param("email_id") String email_id);
	
	
}
