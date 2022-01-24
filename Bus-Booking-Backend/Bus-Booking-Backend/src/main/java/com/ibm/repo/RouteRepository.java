package com.ibm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ibm.entity.Route;

public interface RouteRepository extends JpaRepository<Route, Integer> {
	
	
	@Query(value="select route_id from route where start_point=:start_point and end_point=:end_point",nativeQuery = true)
	int findRouteByStartAndEndPoint(@Param("start_point") String start_point,@Param("end_point") String end_point);
	

}
