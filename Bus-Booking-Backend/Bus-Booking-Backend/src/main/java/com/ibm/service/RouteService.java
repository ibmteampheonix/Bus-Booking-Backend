package com.ibm.service;

import java.util.List;

import com.ibm.entity.Route;

public interface RouteService {
	
	void addRoute(Route route);

	//void updateRoute(Route route);

	boolean deleteRoute(int route);

	Route findByRouteId(int route_id);

	int findRouteByStartAndEndPoint(String start_point, String end_point);

	List<Route> findAll();

}
