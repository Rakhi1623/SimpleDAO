package com.canddella.service;

import java.time.LocalDate;
import java.util.List;

import com.canddella.dao.DriversBookingDAOImp;
import com.canddella.entity.DriversBooking;

public class DriversBookingSericeImp implements DriversBookingSerice {
	DriversBookingDAOImp driversBookingDAOImp = new DriversBookingDAOImp();
	
	@Override
	public DriversBooking searchDriversBooking(String driversBooking_id) {
		
		return driversBookingDAOImp.searchDriversBooking(driversBooking_id);
	}

	@Override
	public void updateDriversBookingr(DriversBooking driversBooking) {
		driversBookingDAOImp.updateDriversBookingr(driversBooking);

	}

	@Override
	public void addDriversBooking(DriversBooking driversBooking) {
		driversBookingDAOImp.addDriversBooking(driversBooking);

	}

	@Override
	public List<DriversBooking> listAllDriversBooking() {
		
		return driversBookingDAOImp.listAllDriversBooking();
	}

	@Override
	public List<DriversBooking> getAllDriversBookingBasedOnDate(LocalDate date) {
		
		return driversBookingDAOImp.getAllDriversBookingBasedOnDate(date);
	}

}
