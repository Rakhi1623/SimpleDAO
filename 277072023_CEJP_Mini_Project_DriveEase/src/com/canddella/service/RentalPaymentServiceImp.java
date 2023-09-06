package com.canddella.service;

import java.util.List;

import com.canddella.dao.RentalPaymentDAOImp;
import com.canddella.entity.RentalPayment;

public class RentalPaymentServiceImp implements RentalPaymentService {
	RentalPaymentDAOImp rentalPaymentDAOImp = new RentalPaymentDAOImp();
	
	
	
	@Override
	public RentalPayment searchrentalPayment(String rentalPayment_id) {
		
		return rentalPaymentDAOImp.searchrentalPayment(rentalPayment_id);
	}

	@Override
	public void addRentalPayment(RentalPayment rentalPayment) {
	
		rentalPaymentDAOImp.addRentalPayment(rentalPayment);
	}

	@Override
	public void updateRentalPayment(RentalPayment rentalPayment) {
		rentalPaymentDAOImp.updateRentalPayment(rentalPayment);
	}

	@Override
	public List<RentalPayment> ListAllRentalPayment() {
	
		return rentalPaymentDAOImp.ListAllRentalPayment();
	}

}
