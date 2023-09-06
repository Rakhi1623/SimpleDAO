package com.canddella.service;

import java.util.List;

import com.canddella.entity.Rental;

public interface RentalService {
	
	Rental searchRental(String rental_id);
	public void updateRental(Rental rental );
	
	public void addRental(Rental rental );
	
	public List<Rental> listAllRental ();
	
}
