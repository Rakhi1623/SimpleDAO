package com.canddella.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import com.canddella.entity.Customer;
import com.canddella.service.CustomerServiceImp;
import com.canddella.service.LoyaltyPointsServiceImp;

public class CustomerUtility {

	public static void main(String[] args) {
		
		customerMenu();
	}
	
	public static void customerMenu() {
		char selectChoice;
		do {
			
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("1.Add Customer \n2.Display All Customer\n3.Update Customer Details\n4.Search Customer");
			int choice = scanner.nextInt();
		
	
		 if(choice==1)
		 {
			 addCustomer();
		 }
		 else if (choice==2) {
			 displayAllCustomer();
			 }
		 else if (choice==3) {
			 updateCustomerDetails();
			 }
		 else if (choice==4) {
			  searchCustomer();
		 }
			  
		 System.out.println("do you want continue");
         selectChoice = scanner.next().charAt(0);
		}while(selectChoice=='y'||selectChoice=='Y');
	}
	
	
	
	private static Customer searchCustomer() {
		CustomerServiceImp customerServiceImp = new CustomerServiceImp();
		Scanner scanner = new Scanner(System.in);
		 System.out.println("Enter the Customer_id: ");
		 String customerId = scanner.nextLine();
			Customer customer = customerServiceImp.searchCustomer( customerId);
		    
	          if (customer != null) {
	        	  
	            System.out.println(" Customer ID " + customer.getCustomer_id() + " " + customer.getCustomer_firstName()+"    "+customer.getCustomer_lastName()+"     "+customer.getCustomer_gender()+"      "+customer.getCustomer_dob()+"    "+customer.getCustomer_phoneNo()+"    "+customer.getCustomer_adharNo());
	        } else {
	            System.out.println("Customer ID not found.");

		}
	          return customer;
	}

	private static void updateCustomerDetails() {
		CustomerServiceImp customerServiceImp = new CustomerServiceImp();
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		/* List<Customer>customerList=customerServiceImp.ListAllCustomer(); */
		Scanner scanner = new Scanner(System.in);
		
		 Customer customer = searchCustomer();
		 
			 if(customer!= null){
				System.out.println("1.Update Customer_firstName\n2.Update Customer_lastName\n3.Update Customer_gender\n4.Update Customer_dob\n5.Update Customer_phoneNo\n6.Update Customer_adharNo");
				int updateChoice = scanner.nextInt();
				if(updateChoice==1) {
					System.out.println("Enter the Customer_firstName: ");
					String updateCustomer_firstName = scanner.nextLine();
					customer.setCustomer_firstName(updateCustomer_firstName);
				}
				else if(updateChoice==2) {
					System.out.println("Enter the Customer_lastName: ");
					String updateCustomer_lastName = scanner.nextLine();
					customer.setCustomer_lastName(updateCustomer_lastName);
				}
				else if(updateChoice==3) {
					System.out.println("Enter the Customer_gender: ");
					String updateCustomer_gender = scanner.nextLine();
					customer.setCustomer_gender(updateCustomer_gender);
				}
				else if(updateChoice==4) {
					System.out.println("Enter the Customer_dob: ");
					String updateCustomer_dob = scanner.nextLine();
					 LocalDate nUpdateCustomer_dob = LocalDate.parse(updateCustomer_dob, formater);
					 customer.setCustomer_dob(nUpdateCustomer_dob);
				}
				else if(updateChoice==5) {
					System.out.println("Enter the Customer_phoneNo: ");
					long updateCustomer_phoneNo = scanner.nextLong();
					customer.setCustomer_phoneNo(updateCustomer_phoneNo);
				}
				else if(updateChoice==6) {
					System.out.println("Enter the Customer_adharNo: ");
					Long updateCustomer_adharNo = scanner.nextLong();
					customer.setCustomer_adharNo(updateCustomer_adharNo);
				}
			
				customerServiceImp.updateCustomer(customer);
			 }
				
		 } 
	
	
	public static void displayAllCustomer() {
			CustomerServiceImp customerServiceImp = new CustomerServiceImp();

      	  ArrayList<Customer>customerList;
      	customerList=(ArrayList<Customer>)customerServiceImp.ListAllCustomer();
      	  for(Customer cus : customerList)
      	  {
                System.out.println( cus.getCustomer_id() + "   " + cus.getCustomer_firstName()+"   "+cus.getCustomer_lastName()+"   "+cus.getCustomer_gender()+"     "+cus.getCustomer_dob()+"   "+cus.getCustomer_phoneNo()+"    "+cus.getCustomer_adharNo());

      	  }
      	  
	}
	

	private static void addCustomer() {
		CustomerServiceImp customerServiceImp = new CustomerServiceImp();
		Scanner scanner = new Scanner(System.in);
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
  		System.out.println("Enter the Customer_id : ");
  		String customer_id = scanner.nextLine();
  		System.out.println("Enter the Customer_firstname : ");
  		 String customer_firstname= scanner.nextLine();
  		System.out.println("Enter the Customer_lastname : ");
 		 String customer_lastname= scanner.nextLine();
 		System.out.println("Enter the Customer_gender : ");
		 String customer_gender= scanner.nextLine();
 		System.out.println("Enter the Customer_dob (yyyy-MM-dd):");
        String customer_dob = scanner.nextLine();
        
        System.out.println("Enter the Customer_phoneNo : ");
		 long customer_phoneNo= scanner.nextLong();
		 scanner.nextLine();
		 
		 System.out.println("Enter the Customer_adharNo : ");
		 long Customer_adharNo= scanner.nextLong();
		 
		 LocalDate customer_dob1 = LocalDate.parse(customer_dob,formater);
		customerServiceImp.addCustomer(new Customer(customer_id,customer_firstname,customer_lastname,customer_gender,customer_dob1,customer_phoneNo,Customer_adharNo));
		
		System.out.println("New Customer Added successfully.");
		

	}
	}



