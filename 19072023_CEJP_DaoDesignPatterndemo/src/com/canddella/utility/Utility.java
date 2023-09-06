package com.canddella.utility;

import java.util.Scanner;

import com.canddella.Service.CustomerServiceImpl;
import com.canddella.dao.CustomerDAOImpl;
import com.canddella.entity.Customer;

public class Utility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CustomerDAOImpl customerDAO = new CustomerDAOImpl();
		
		CustomerServiceImpl customerService = new CustomerServiceImpl();
		System.out.println("Enter the customerCode : ");
		Scanner scanner = new Scanner(System.in);
		String customerId = scanner.nextLine();
		Customer customer = customerService.searchCustomer( customerId);
		 
	       
          if (customerId != null) {
            System.out.println(" Customer ID " + customer.getCustomerCode() + ": " + customer.getCustomerName());
        } else {
            System.out.println("Customer ID not found.");

	}

}
}