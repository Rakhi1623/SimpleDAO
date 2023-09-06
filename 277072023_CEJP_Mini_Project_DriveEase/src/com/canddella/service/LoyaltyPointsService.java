package com.canddella.service;

import java.util.List;

import com.canddella.entity.Customer;
import com.canddella.entity.LoyaltyPoints;

public interface LoyaltyPointsService {

	
	
	public int searchLoyaltyPoints(Customer customer);
	
	public boolean doesCustomerExist(String customer_id);

	public void updateLoyaltyPoints(String customer_id);
	
	public void addLoyaltyPoints(String customer_id) ;
	
	public List<LoyaltyPoints> listAllLoyaltyPoint ();


}
