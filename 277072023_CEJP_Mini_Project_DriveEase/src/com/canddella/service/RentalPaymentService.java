package com.canddella.service;

import java.util.List;

import com.canddella.entity.RentalPayment;

public interface RentalPaymentService {
	RentalPayment searchrentalPayment(String rentalPayment_id);
	public void addRentalPayment(RentalPayment rentalPayment);
	public void updateRentalPayment(RentalPayment rentalPayment);
	public List<RentalPayment>ListAllRentalPayment();
}


