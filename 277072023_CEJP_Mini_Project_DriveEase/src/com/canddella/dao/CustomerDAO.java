package com.canddella.dao;

import java.util.List;

import com.canddella.entity.Customer;



public interface CustomerDAO {
	
	
	Customer searchCustomer(String customer_id);
	
	public void updateCustomer(Customer customer );
	
	public void addCustomer(Customer customer);
	
	public List<Customer> listAllCustomer ();

}
