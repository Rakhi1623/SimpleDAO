package com.canddella.utility;

import java.util.Scanner;

import com.itextpdf.text.DocumentException;

public class MainUtility {

	public static void main(String[] args) throws DocumentException {
		System.out.println("      ");
		runMainMenu();
		showWelcomeMessage();

	}

	private static void runMainMenu() {
		System.out.println("         *****************  Welcome to Drive Ease ******************");
		System.out.println("  ");
		System.out.println("                    Explore More..... Rent With DriveEase.......    ");
		System.out.println("   ");
		System.out.println("           ------------------------------~*~---------------------------------");

	}

	private static void showWelcomeMessage() throws DocumentException {
		char selectChoice;
		Scanner scanner = new Scanner(System.in);

		do {
			System.out.println("   ");
			System.out.println("               ****** DriveEase Main Menu  *******       ");
			System.out.println("   ");
			System.out.println("       		 	1.Customer Registration Management");
			System.out.println("       		 	2.Vehicle display Management");
			System.out.println("       			3.Booking Vehicle Management");
			System.out.println("        		4.Payments Management ");
			System.out.println("			5.FeedBack Management");
			System.out.println("        		6.Vehicle Management  ");
			System.out.println("         		7.Driver Management  ");
			System.out.println("       			8.Rental Management  ");
			System.out.println("        		9.Discounts Management  ");

			System.out.println("Enter your choice: ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				CustomerUtility.customerMenu();
				break;
			case 2:
				VehicleUtility.vehicleMenu();
				break;
			case 3:
				BookingUtility.bookingMenu();
				break;
			case 4:
				BookingPaymentUtility.paymentMenu();
				break;
			case 5:
				FeedbackAnalysisUtility.feedbackAnalysisMenu();
				break;
			case 6:
				do {
				System.out.println("1.Vehicle type management\n2.Vehicle management");
				System.out.println("Enter your choice: ");
				int choiceS = scanner.nextInt();
				if(choiceS==1) {
					VehicleTypeUtility.vehicleTypeMenu();
				}
				if(choiceS==2) {
					VehicleUtility.vehicleMenu();
				}
				System.out.println("Do you want to continue (y/n)?");
				selectChoice = scanner.next().charAt(0);
			} while (selectChoice == 'y' || selectChoice == 'Y');

				break;
			case 7:
				do {
					System.out.println("1.Driver Management\n2.Drivers Booking Management");
					System.out.println("Enter your choice: ");
					int choicess = scanner.nextInt();
					if(choicess==1) {
						DriversUtility.driverMenu();
					}
					if(choicess==2) {
						DriversBookingUtility.driverBookingMenu();
					}
					System.out.println("Do you want to continue (y/n)?");
					selectChoice = scanner.next().charAt(0);
				} while (selectChoice == 'y' || selectChoice == 'Y');	
				break;
			case 8:
				RentalUtility.rentalMenu();
				break;
			case 9:
				do {
					System.out.println("1.LoyaltyPoint Discounts Management\n2.Referral Discounts Management");
					System.out.println("Enter your choice: ");
					int choicess = scanner.nextInt();
					if(choicess==1) {
						LoyaltyPointsUtility.loyaltyPointsMenu();
					}
					if(choicess==2) {
						ReferralDiscountsUtility.ReferralDiscountsMenu();
						}
					System.out.println("Do you want to continue (y/n)?");
					selectChoice = scanner.next().charAt(0);
				} while (selectChoice == 'y' || selectChoice == 'Y');	
				break;
				
			default:
				System.out.println("Invalid choice. Please select again.");
			}

			System.out.println("Do you want to continue (y/n)?");
			selectChoice = scanner.next().charAt(0);
		} while (selectChoice == 'y' || selectChoice == 'Y');

		System.out.println("Thank you for using Drive Ease!!!!... Have a great day !!!!!!.........");
	}

}
