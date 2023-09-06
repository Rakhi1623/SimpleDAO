package com.canddella.dao;

import java.time.LocalDate;
import java.util.List;

import com.canddella.entity.DriversBooking;

public interface DriversBookingDAO {
	
	DriversBooking searchDriversBooking(String driversBooking_id);
	
	public void updateDriversBookingr(DriversBooking driversBooking );
	
	public void addDriversBooking(DriversBooking driversBooking);
	
	public List<DriversBooking> listAllDriversBooking();
	
	public List<DriversBooking>getAllDriversBookingBasedOnDate(LocalDate date);


}
