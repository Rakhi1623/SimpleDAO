package com.canddella.service;

import java.util.List;

import com.canddella.entity.Drivers;

public interface DriversService {
Drivers searchDrivers(String driver_Id);
	
	public void updateDrivers(Drivers driver );
	
	public void addDrivers(Drivers driver);
	
	public List<Drivers> listAllDrivers ();


}
