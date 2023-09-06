package com.canddella.service;

import java.util.List;

import com.canddella.dao.RentalDAOImp;
import com.canddella.entity.Rental;

public class RentalServiceImp implements RentalService {
	
	
	RentalDAOImp rentalDAOImp = new RentalDAOImp();
	
	@Override
	public void updateRental(Rental rental) {
		rentalDAOImp.updateRental(rental);
	}

	@Override
	public void addRental(Rental rental) {
		rentalDAOImp.addRental(rental);
		
	}

	@Override
	public List<Rental> listAllRental() {
		
		return rentalDAOImp.listAllRental();
	}

	@Override
	public Rental searchRental(String rental_id) {
		
		return rentalDAOImp.searchRental(rental_id) ;
	 
	}

	

}
