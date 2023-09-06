package com.canddella.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.canddella.entity.BookingPayment;
import com.canddella.entity.Rental;
import com.canddella.entity.RentalPayment;
import com.canddella.service.BookingPaymentServiceImp;
import com.canddella.service.RentalPaymentServiceImp;

public class RentalPaymentUtility {

	public static void main(String[] args) {
	rentalPaymentMenu();

	}

	private static void rentalPaymentMenu() {
		char selectChoice;
		do {
			Scanner scanner = new Scanner(System.in);

			System.out.println("1.Add RentalPayment \n2.Display All RentalPayment\n3.Update RentalPayment\n4.Search RentalPayment");
			int choice = scanner.nextInt();
			if (choice == 1) {
				addRentalPayment();

			} else if (choice == 2) {
				displayAllRentalPayment();

			} else if (choice == 3) {
				updateRentalPaymentDetails();
			} else if (choice == 4) {
				searchRentalPayment();
			}
			System.out.println("do you want continue");
			selectChoice = scanner.next().charAt(0);
		} while (selectChoice == 'y' || selectChoice == 'Y');
	}

	private static RentalPayment searchRentalPayment() {
		RentalPaymentServiceImp rentalPaymentServiceImp = new RentalPaymentServiceImp();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Rentalpayment_id: ");
		String rentalPaymentId = scanner.nextLine();
		RentalPayment rentalPayment = rentalPaymentServiceImp.searchrentalPayment(rentalPaymentId);

		if (rentalPayment != null) {

			System.out.println(rentalPayment.getRentalPayment_id() + "   " 	+ rentalPayment.getRental().getRental_id()+"     "+rentalPayment.getAmount()+"    "+rentalPayment.getPayment_date()+"     "+rentalPayment.getPayment_method());
		} else {
			System.out.println("Payment ID not found.");

		}
		return rentalPayment;
	}
	
		
		
	

	private static void updateRentalPaymentDetails() {
		RentalPaymentServiceImp rentalPaymentServiceImp = new RentalPaymentServiceImp();
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		Scanner scanner = new Scanner(System.in);
		RentalPayment rentalPayment = searchRentalPayment();

		if (rentalPayment != null) {
			System.out.println("1.update amount\n2.update payment date \n3.update payment method ");
			int updateChoice = scanner.nextInt();

			if (updateChoice == 1) {
				scanner.nextLine();
				System.out.println("Enter the Amount : ");
				Long updateamount = scanner.nextLong();
				rentalPayment.setAmount(updateamount);

				rentalPaymentServiceImp.updateRentalPayment(rentalPayment);;

			}
			else if (updateChoice == 2) {
				scanner.nextLine();
				System.out.println("Enter the Payment date : ");
				String updatePayment_date = scanner.nextLine();
				 LocalDate nUpdatePayment_date = LocalDate.parse(updatePayment_date,formater);
				 rentalPaymentServiceImp.updateRentalPayment(rentalPayment);

			}
			else if (updateChoice == 3) {
				scanner.nextLine();
				System.out.println("Enter the payment method : ");
				String updatePaymentMethod = scanner.nextLine();
				rentalPayment.setPayment_method(updatePaymentMethod);;

				rentalPaymentServiceImp.updateRentalPayment(rentalPayment);;

			}
			
			
		}
	}		
	

	private static void displayAllRentalPayment() {
		RentalPaymentServiceImp rentalPaymentServiceImp = new RentalPaymentServiceImp();
		List<RentalPayment> rentalPaymentList = rentalPaymentServiceImp.ListAllRentalPayment();
		for (RentalPayment rentalpay : rentalPaymentList) {
			System.out.println(
					rentalpay.getRentalPayment_id()+ "   " +rentalpay.getRental().getRental_id()+ "    " + rentalpay.getAmount()+"    "+rentalpay.getPayment_date()+"     "+rentalpay.getPayment_method());

		}
	}		
	

	private static void addRentalPayment() {
		RentalPaymentServiceImp rentalPaymentServiceImp = new RentalPaymentServiceImp();
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the RentalPayment_id : ");
		String rentalPayment_id = scanner.nextLine();
		System.out.println("Enter the Rental_id : ");
		String rental_id = scanner.nextLine();
		Rental rental = new Rental();
		rental.setRental_id(rental_id);
		System.out.println("Enter the Amount : ");
		Long amount = scanner.nextLong();
		scanner.nextLine();
		System.out.println("Enter the Payment_date : ");
		String payment_date = scanner.nextLine();
		System.out.println("Enter the Payment_method : ");
		String Payment_method = scanner.nextLine();
		LocalDate nPayment_date = LocalDate.parse(payment_date,formater);
		rentalPaymentServiceImp.addRentalPayment(new RentalPayment(rentalPayment_id,amount,nPayment_date,Payment_method,rental));
	}

		
	
		
	}

	
		
	
	


