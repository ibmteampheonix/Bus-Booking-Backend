
//BusController
package com.ibm.rest;

//import java.time.LocalTime;
import java.util.List;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.entity.Bus;
import com.ibm.entity.Route;
import com.ibm.service.BusService;
import com.ibm.service.RouteService;

@CrossOrigin
@RestController
public class BusController {
	
	@Autowired
	private BusService service;
	
	@Autowired
	private RouteService route_service;  
	
	@PostMapping(value="/bus/{route_id}",consumes = {"application/json"})
	public void addBus(@RequestBody Bus bus, @PathVariable int route_id) {
		service.addBus(bus,route_id);
	}
	/*
	@PutMapping(value="/bus/update/{route_id}",consumes = "application/json")
	public void updateBus(@PathVariable int route_id,@RequestBody Bus bus)
	{
		service.updateBus(bus,route_id);
	}
	*/
	
	@DeleteMapping(value="/bus/del/{bus_id}",produces="application/json")
	public boolean deleteBus(@PathVariable int bus_id) 
	{	
		return service.deleteBus(bus_id);
	}
	
	@GetMapping(value="/bus/{start_point}/{end_point}",produces = "application/json")
	public List<Bus> findBusByStartAndEndPoint(@PathVariable String start_point,@PathVariable String end_point)
	{
		int route_id = route_service.findRouteByStartAndEndPoint(start_point, end_point);
		//return service.findBusByStartAndEndPoint(start_point, end_point);
		return service.findByRouteId(route_id);
	}
	
	@GetMapping(value="/bus/all",produces = "application/json")
	public List<Bus> findAllBus() {
		return service.findAllBus();
	}
	
	@GetMapping(value="/bus/bybus/{bus_id}",produces = "application/json")
	public Bus findByBusId(@PathVariable int bus_id)
	{
		return service.findByBusId(bus_id);
	}
	
	@GetMapping(value="/bus/byroute/{route_id}",produces = "application/json")
	public List<Bus> findByRouteId(@PathVariable int route_id)
	{
		return service.findByRouteId(route_id);
	}
	
	
}