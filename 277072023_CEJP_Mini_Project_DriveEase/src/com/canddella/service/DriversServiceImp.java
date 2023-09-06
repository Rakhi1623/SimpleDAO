package com.canddella.service;

import java.util.List;

import com.canddella.dao.DriversDAOImp;
import com.canddella.entity.Drivers;

public class DriversServiceImp implements DriversService {
	DriversDAOImp driversDAOImp = new DriversDAOImp();
	

	@Override
	public Drivers searchDrivers(String driver_Id) {
		
		return driversDAOImp.searchDrivers(driver_Id);
	}

	@Override
	public void updateDrivers(Drivers driver) {
		driversDAOImp.updateDrivers(driver);

	}

	@Override
	public void addDrivers(Drivers driver) {
		driversDAOImp.addDrivers(driver);

	}

	@Override
	public List<Drivers> listAllDrivers() {
		
		return driversDAOImp.listAllDrivers();
	}

}
