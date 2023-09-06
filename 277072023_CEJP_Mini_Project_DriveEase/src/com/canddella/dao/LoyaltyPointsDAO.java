package com.canddella.dao;

import java.util.List;

import com.canddella.entity.Customer;
import com.canddella.entity.LoyaltyPoints;

public interface LoyaltyPointsDAO {
	
	public boolean doesCustomerExist(String customer_id);
	
	public int searchLoyaltyPoints(Customer customer);
	
	public void updateLoyaltyPoints(String customer_id) ;
	
	public void addLoyaltyPoints( String customer_id);
	
	public List<LoyaltyPoints> listAllLoyaltyPoint ();

}
