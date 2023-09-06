package com.canddella.dao;

import java.util.List;

import com.canddella.entity.Vehicle;
import com.canddella.entity.VehicleType;

public interface VehicleDAO {
	
	
	Vehicle searchVehicle(String vehicle_id);
	public void addVehicle(Vehicle vehicle);
	public void updateVehicle(Vehicle vehicle);
	public List<Vehicle>ListAllVehicle();
	public List<Vehicle> getAllVehicleBaseOnType(VehicleType vehicleType) ;
}
