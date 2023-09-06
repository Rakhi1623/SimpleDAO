package com.canddella.service;

import java.util.List;

import com.canddella.dao.CustomerDAOImp;
import com.canddella.entity.Customer;

public class CustomerServiceImp implements CustomerService{
	
	
	CustomerDAOImp customerDAOImp = new CustomerDAOImp();
	
	Customer customer;
	
		
	

	@Override
	public void addCustomer(Customer customer) {
	
		customerDAOImp.addCustomer(customer);
	}

	@Override
	public List<Customer> ListAllCustomer() {
		
	
		return customerDAOImp.listAllCustomer();
	}

	@Override
	public void updateCustomer(Customer customer) {
		
		customerDAOImp.updateCustomer(customer);
		
	}

	@Override
	public Customer searchCustomer(String customer_id) {
		
		return customerDAOImp.searchCustomer(customer_id);
	}
	
	

}
