package com.ibm.service;

import java.util.List;

//import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.Route;
import com.ibm.repo.RouteRepository;

@Service
public class RouteServiceImpl implements RouteService {

	@Autowired
	private RouteRepository repo;
	
	@Override
	@Transactional
	public void addRoute(Route route) {
		repo.save(route);
	}
	/*
	@Override
	public void updateRoute(Route route) {
		//repo.save(route);	
	}
	*/
	@Override
	public boolean deleteRoute(int route) {
		repo.deleteById(route);
		return true;
	}

	@Override
	public Route findByRouteId(int route_id) {
		return repo.findById(route_id).get();
	}

	/*
	 * @Override
	
	public int findRouteByStartAndEndPoint(String start_point, String end_point) {
		//return repo.findRouteByStartAndEndPoint(start_point, end_point);
	}*/

	@Override
	public List<Route> findAll() {
		return repo.findAll();
	}
	@Override
	public int findRouteByStartAndEndPoint(String start_point, String end_point) {
		return repo.findRouteByStartAndEndPoint(start_point, end_point);
	}
	

}
