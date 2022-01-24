package com.ibm.service;

//import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.Bus;
import com.ibm.repo.BusRepository;
import com.ibm.repo.RouteRepository;

@Service
public class BusServiceImpl implements BusService {
	
	@Autowired
	private BusRepository repo;
	
	@Autowired
	private RouteRepository route_repo;
	
	@Override
	public void addBus(Bus bus, int route_id) {
		bus.setRoute(route_repo.findById(route_id).get());
		repo.save(bus);
	}

	/*
	@Override
	public void updateBus(Bus bus, int route_id) {
		bus.setRoute(route_repo.findById(route_id).get());
		repo.save(bus);
	}
	*/

	@Override
	public boolean deleteBus(int bus) {
		repo.deleteById(bus);
		return true;
	}

	@Override
	public List<Bus> findAllBus() {
		return repo.findAll();
	}

	@Override
	public List<Bus> findByRouteId(int route_id) {
		return repo.findByRouteId(route_id);
	}

	@Override
	public Bus findByBusId(int bus_id) {
		return repo.findByBusId(bus_id);
	}


	/*@Override
	public List<Bus> finaAllByTimeBetween(LocalTime start_time, LocalTime end_time) {
		return repo.finaAllByTimeBetween(start_time, end_time);
	}*/
}

