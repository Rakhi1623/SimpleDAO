package com.canddella.dao;

import java.time.LocalDate;
import java.util.List;

import com.canddella.entity.Drivers;

public interface DriversDAO {
	
	Drivers searchDrivers(String driver_Id);
	
	public void updateDrivers(Drivers driver );
	
	public void addDrivers(Drivers driver);
	
	public List<Drivers> listAllDrivers ();
	


}


