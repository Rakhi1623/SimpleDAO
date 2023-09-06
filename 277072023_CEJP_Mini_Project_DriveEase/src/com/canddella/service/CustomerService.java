package com.canddella.service;

import java.util.List;

import com.canddella.entity.Customer;

public interface CustomerService {
	
	public void updateCustomer(	Customer customer);
	public void addCustomer (Customer customer);
	public List<Customer>ListAllCustomer();
	Customer searchCustomer(String customer_id);

}
