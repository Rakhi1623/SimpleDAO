package com.canddella.service;

import java.util.List;

import com.canddella.entity.Vehicle;

public interface VehicleService {

	public void addVehicle(Vehicle vehicle);
	public void updateVehicle(Vehicle vehicle);
	public List<Vehicle>ListAllVehicle();
	Vehicle searchVehicle(String vehicle_id);
}

