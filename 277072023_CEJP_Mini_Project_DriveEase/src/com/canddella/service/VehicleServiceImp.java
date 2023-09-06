package com.canddella.service;

import java.util.List;

import com.canddella.dao.VehicleDAOImp;
import com.canddella.entity.Vehicle;

public class VehicleServiceImp implements VehicleService {
	
	VehicleDAOImp vehicleDAOImp = new VehicleDAOImp();

	@Override
	public void addVehicle(Vehicle vehicle) {
		vehicleDAOImp.addVehicle(vehicle);
		
	}

	@Override
	public void updateVehicle(Vehicle vehicle) {
		vehicleDAOImp.updateVehicle(vehicle);
	}

	@Override
	public List<Vehicle> ListAllVehicle() {
		
		return vehicleDAOImp.ListAllVehicle();
	}

	@Override
	public Vehicle searchVehicle(String vehicle_id) {
		
		return vehicleDAOImp.searchVehicle(vehicle_id) ;
	}
	
	

}
