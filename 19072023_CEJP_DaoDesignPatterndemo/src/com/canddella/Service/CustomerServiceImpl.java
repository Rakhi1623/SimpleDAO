package com.canddella.Service;

import com.canddella.dao.CustomerDAOImpl;
import com.canddella.entity.Customer;

public class CustomerServiceImpl implements CustomerService{

	@Override
	public Customer searchCustomer(String customerCode) {
		// TODO Auto-generated method stub
		CustomerDAOImpl customerDaoImp= new CustomerDAOImpl();
		
		
		return customerDaoImp.searchCustomer(customerCode) ;
	}

	

	
}
