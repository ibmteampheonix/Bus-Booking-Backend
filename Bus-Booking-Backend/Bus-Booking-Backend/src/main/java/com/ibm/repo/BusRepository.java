package com.ibm.repo;

import java.util.List;

//import java.time.LocalTime;
//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ibm.entity.Bus;
import com.ibm.entity.Seat;



public interface BusRepository extends JpaRepository<Bus, Integer> {
	
	@Query(value="select * from bus where route_id=:route_id", nativeQuery = true)
	List<Bus> findByRouteId(@Param("route_id") int route_id);
	
	@Query(value="select * from bus where bus_id=:bus_id", nativeQuery = true)
	Bus findByBusId(@Param("bus_id") int bus_id);
	
	//List<Bus> finaAllByTimeBetween(LocalTime start_time, LocalTime end_time);

}