package com.ibm.service;

//import java.time.LocalTime;
import java.util.List;

import com.ibm.entity.Bus;
import com.ibm.entity.Route;

public interface BusService {
	void addBus(Bus bus, int route_id);
	
	//void updateBus(Bus bus, int route_id);
	
	boolean deleteBus(int bus);
	
	List<Bus> findAllBus();
	
	List<Bus> findByRouteId(int route_id);
	
	Bus findByBusId(int bus_id);

	/*List<Bus> finaAllByTimeBetween(LocalTime start_time, LocalTime end_time);*/
}
