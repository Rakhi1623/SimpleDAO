package com.canddella.service;

import java.util.List;

import com.canddella.dao.LoyaltyPointsDAOImp;
import com.canddella.entity.Customer;
import com.canddella.entity.LoyaltyPoints;

public class LoyaltyPointsServiceImp implements LoyaltyPointsService {
	LoyaltyPointsDAOImp loyaltyPointDAOImp = new LoyaltyPointsDAOImp();

	@Override
	public int searchLoyaltyPoints(Customer customer) {
		
		return loyaltyPointDAOImp.searchLoyaltyPoints(customer);
	}

	@Override
	public void updateLoyaltyPoints(String customer_id) {
		loyaltyPointDAOImp.updateLoyaltyPoints(customer_id);

	}

	@Override
	public void addLoyaltyPoints(String customer_id) {
		loyaltyPointDAOImp.addLoyaltyPoints( customer_id);

	}

	@Override
	public List<LoyaltyPoints> listAllLoyaltyPoint() {
		
		return loyaltyPointDAOImp.listAllLoyaltyPoint();
	}

	@Override
	public boolean doesCustomerExist(String customer_id) {
		
		return loyaltyPointDAOImp.doesCustomerExist(customer_id);
	}

	
	}

	

