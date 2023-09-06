package com.canddella.dao;

import java.util.List;

import com.canddella.entity.Customer;
import com.canddella.entity.Rental;



public interface RentalDAO {
	Rental searchRental(String rental_id);
	
	public void updateRental(Rental rental );
	
	public void addRental(Rental rental );
	
	public List<Rental> listAllRental ();

}

