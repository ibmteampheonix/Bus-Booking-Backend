
//RouteController
package com.ibm.rest;

import java.util.List;


import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.entity.Route;
import com.ibm.service.RouteService;

@CrossOrigin
@RestController
public class RouteController {
	
	@Autowired
	private RouteService service;
	
	@Transactional
	@PostMapping(value = "/route", consumes= "application/json")
	public void addRoute(@RequestBody Route route) {
		service.addRoute(route);
	}
	/*
	@PutMapping(value="/route/update",consumes = "application/json")
	public void updateRoute(@RequestBody Route route)
	{
		service.updateRoute(route);
	}
	*/
	@DeleteMapping(value="/route/delete/{route_id}",produces = "application/json")
	public boolean deleteRoute(@PathVariable int route_id)
	{
		return service.deleteRoute(route_id);
	}
	
	@GetMapping(value="/route/show/{route_id}",produces = "application/json")
	public Route findByRouteId(@PathVariable int route_id)
	{
		return service.findByRouteId(route_id);
	}
	
	@GetMapping(value="/route/{start_point}/{end_point}",produces = "application/json")
	public int findRouteByStartAndEndPoint(@PathVariable String start_point,@PathVariable String end_point)
	{
		return service.findRouteByStartAndEndPoint(start_point, end_point);
	}
	
	@GetMapping(value="/route/all",produces = "application/json")
	public List<Route> findAll()
	{
		return service.findAll();
	}
	
}