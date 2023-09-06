package com.canddella.utility;

import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Customer;
import com.canddella.entity.LoyaltyPoints;
import com.canddella.service.CustomerServiceImp;
import com.canddella.service.LoyaltyPointsServiceImp;

public class LoyaltyPointsUtility {

	public static void main(String[] args) {
		loyaltyPointsMenu();

	}

	public static void loyaltyPointsMenu() {
		char selectChoice;
		do {
			Scanner scanner = new Scanner(System.in);

			System.out.println(
					"1.Add  LoyaltyPoints \n2.Display All LoyaltyPoints\n3.UpdateLoyaltyPoints\n4.Search LoyaltyPoints");
			int choice = scanner.nextInt();
			if (choice == 1) {
				addLoyaltyPoints();

			} else if (choice == 2) {
				displayAllLoyaltyPoints();

			} else if (choice == 3) {
				updateLoyaltyPointsDetails(null);
			} else if (choice == 4) {
				searchLoyaltyPoints();
			}
			System.out.println("do you want continue");
			selectChoice = scanner.next().charAt(0);
		} while (selectChoice == 'y' || selectChoice == 'Y');
	}

	private static LoyaltyPoints searchLoyaltyPoints() {
		LoyaltyPoints loyaltyPoints=null;
		LoyaltyPointsServiceImp loyaltyPointsServiceImp = new LoyaltyPointsServiceImp();
		CustomerServiceImp customerServiceImp = new CustomerServiceImp();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Customer_id: ");
		String customer_id = scanner.nextLine();
		Customer customerDetails = customerServiceImp.searchCustomer(customer_id);

		int loyaltyPoint = loyaltyPointsServiceImp.searchLoyaltyPoints(customerDetails);
		
		
		return loyaltyPoints;
	}
	

	

	private static void updateLoyaltyPointsDetails(String customer_id) {
		LoyaltyPointsServiceImp loyaltyPointsServiceImp = new LoyaltyPointsServiceImp();

		Scanner scanner = new Scanner(System.in);
		LoyaltyPoints loyaltyPoints = searchLoyaltyPoints();

		if (loyaltyPoints != null) {
			System.out.println("1.update loyaltyPoint:");
			int updateChoice = scanner.nextInt();

			if (updateChoice == 1) {
				scanner.nextLine();
				System.out.println("Enter the LoyaltyPoints : ");
				int updateLoyaltyPoints = scanner.nextInt();
				loyaltyPoints.setLoyaltyPoint(updateLoyaltyPoints);

				// loyaltyPointsServiceImp.updateLoyaltyPoints(customer_id);
				;

			}
		}
	}

	private static void displayAllLoyaltyPoints() {
		LoyaltyPointsServiceImp loyaltyPointsServiceImp = new LoyaltyPointsServiceImp();
		List<LoyaltyPoints> loyaltyPointList = loyaltyPointsServiceImp.listAllLoyaltyPoint();
		for (LoyaltyPoints loyalty : loyaltyPointList) {
			System.out.println(loyalty.getLoyaltPoints_Id() + "   " + loyalty.getCustomer().getCustomer_id() + "    "
					+ loyalty.getLoyaltyPoint());

		}
	}

	public static void addLoyaltyPoints() {

		LoyaltyPointsServiceImp loyaltyPointsServiceImp = new LoyaltyPointsServiceImp();

		Scanner scanner = new Scanner(System.in); //
		System.out.println("Enter the LoyaltyPoints_Id : ");
		String loyaltyPoints_id = scanner.nextLine();
		CustomerUtility.displayAllCustomer();
		System.out.println("Enter the Customer_id : ");
		String customer_id1 = scanner.nextLine();
		Customer customer = new Customer();
		customer.setCustomer_id(customer_id1);
		System.out.println("Enter the LoyaltyPoints : ");
		int loyaltyPoints = scanner.nextInt();

	}

}
