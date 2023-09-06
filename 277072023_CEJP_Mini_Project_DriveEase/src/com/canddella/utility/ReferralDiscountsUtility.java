package com.canddella.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import com.canddella.entity.Booking;
import com.canddella.entity.Customer;
import com.canddella.entity.Drivers;
import com.canddella.entity.ReferralDiscounts;
import com.canddella.entity.Rental;
import com.canddella.service.DriversServiceImp;
import com.canddella.service.ReferralDiscountsServiceImp;
import com.canddella.service.RentalServiceImp;

public class ReferralDiscountsUtility {

	public static void main(String[] args) {
		ReferralDiscountsMenu();
	}

	public static void ReferralDiscountsMenu() {
		char selectChoice;
		do {

			Scanner scanner = new Scanner(System.in);

			System.out.println(
					"1.Add DriversBooking\n2.Display All DriversBooking\n3.Update DriversBooking Details\n4.Search DriversBooking");
			int choice = scanner.nextInt();

			if (choice == 1) {
				addReferralDiscounts();
			} else if (choice == 2) {
				displayAllReferralDiscounts();
			} else if (choice == 3) {
				updateReferralDiscountsDetails() ;
				
			} else if (choice == 4) {
				searchReferralDiscounts();
			}

			System.out.println("do you want continue");
			selectChoice = scanner.next().charAt(0);
		} while (selectChoice == 'y' || selectChoice == 'Y');
	}

	

	private static void updateReferralDiscountsDetails() {
	    ReferralDiscountsServiceImp referralDiscountServiceImp = new ReferralDiscountsServiceImp();


		Scanner scanner = new Scanner(System.in);
		 ReferralDiscounts referralDiscount =	searchReferralDiscounts();;

		if (referralDiscount != null) {
			System.out.println("1.update Status:");
			int updateChoice = scanner.nextInt();

			if (updateChoice == 1) {
				scanner.nextLine();
				System.out.println("Enter the Status : ");
				boolean updatestatus = scanner.nextBoolean();
				referralDiscount.setStatus(updatestatus);

				referralDiscountServiceImp.updateReferralDiscounts(referralDiscount);

			}
		}
	}

		
	

	private static ReferralDiscounts searchReferralDiscounts() {
		ReferralDiscountsServiceImp referralDiscountServiceImp = new ReferralDiscountsServiceImp();

		Scanner scanner = new Scanner(System.in);
		 System.out.println("Enter the ReferralDiscount_id: ");
		 String referralDiscount_id = scanner.nextLine();
		 ReferralDiscounts referralDiscount = referralDiscountServiceImp.searchReferralDiscount( referralDiscount_id);
		    
	          if (referralDiscount != null) {
	        	  
	              System.out.println( referralDiscount.getReferralDiscount_id()+ "   " + referralDiscount.getBooking().getBooking_id()+"   "+referralDiscount.getCustomer().getCustomer_id()+"   "+referralDiscount.isStatus());
	        } else {
	            System.out.println("referralDiscount ID not found.");

		}
	          return referralDiscount;

	}
	private static void updateReferralDiscountsDetails(String customer_id) {
	    ReferralDiscountsServiceImp referralDiscountServiceImp = new ReferralDiscountsServiceImp();

	    Scanner scanner = new Scanner(System.in);

	    ReferralDiscounts referralDiscount = searchReferralDiscounts();

	    if (referralDiscount != null) {
	        System.out.println("1.Update Status");
	        int updateChoice = scanner.nextInt();
	        if (updateChoice == 1) {
	            System.out.println("Enter the new Status (true/false): ");
	            boolean updateStatus = scanner.nextBoolean();
	            referralDiscount.setStatus(updateStatus);

				referralDiscountServiceImp.updateReferralDiscounts(referralDiscount);
	            System.out.println("Referral discount status updated.");
	        }
	    }
	}
	public void updateStatus(String customer_id) {
		ReferralDiscountsServiceImp referralDiscountServiceImp = new ReferralDiscountsServiceImp();
		
		
		Scanner scanner = new Scanner(System.in);
		
		ReferralDiscounts referralDiscounts  = searchReferralDiscounts();
		 
			 if(referralDiscounts!= null){
				System.out.println("1.Update Status");
				int updateChoice = scanner.nextInt();
				if(updateChoice==1) {
					System.out.println("Enter the Status: ");
					String status = scanner.nextLine();
					referralDiscounts.setStatus(false);
	
			 }	
		
			 }
	}

	private static void displayAllReferralDiscounts() {
		ReferralDiscountsServiceImp referralDiscountServiceImp = new ReferralDiscountsServiceImp();

    	  ArrayList<ReferralDiscounts>referralDiscountsList;
    	  referralDiscountsList=(ArrayList<ReferralDiscounts>)referralDiscountServiceImp.listAllReferralDiscount();
    	  for(ReferralDiscounts refe : referralDiscountsList)
    	  {
              System.out.println( refe.getReferralDiscount_id()+ "   " + refe.getBooking().getBooking_id()+"   "+refe.getCustomer().getCustomer_id()+"   "+refe.isStatus());

    	  }
		
	}
		
	

	private static void addReferralDiscounts() {
		ReferralDiscountsServiceImp referralDiscountServiceImp = new ReferralDiscountsServiceImp();
		Scanner scanner = new Scanner(System.in);
		
  		System.out.println("Enter the ReferralDiscount_id : ");
  		String referralDiscount_id = scanner.nextLine();
  		System.out.println("Enter the Booking_id : ");
  		 String booking_id= scanner.nextLine();
  		 Booking booking = new Booking();
  		 booking.setBooking_id(booking_id);
  		System.out.println("Enter the  Customer_id: ");
 		 String customer_id= scanner.nextLine();
 		 Customer customer = new Customer();
 		customer.setCustomer_id(customer_id);
		 
		 System.out.println("Enter the Status: ");
		 boolean status= scanner.nextBoolean();
		 
		
		 referralDiscountServiceImp.addReferralDiscount(new ReferralDiscounts(referralDiscount_id,status,booking,customer));
		
		System.out.println("New Driver Added successfully.");
		

		
	}
	
	

	}
		
	


