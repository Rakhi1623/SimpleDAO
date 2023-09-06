package com.canddella.service;

import java.util.List;

import com.canddella.dao.VehicleTypeDAOImp;
import com.canddella.entity.VehicleType;

public class VehicleTypeServiceImp implements VehicleTypeService {
	VehicleTypeDAOImp vehicleTypeDAOImp = new VehicleTypeDAOImp();
	@Override
	public List<VehicleType> ListAllVehicle() {
	
		return vehicleTypeDAOImp.ListAllVehicle();
	}

}
