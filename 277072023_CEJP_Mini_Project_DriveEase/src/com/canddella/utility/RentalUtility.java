package com.canddella.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Customer;
import com.canddella.entity.Rental;
import com.canddella.entity.Vehicle;
import com.canddella.service.CustomerServiceImp;
import com.canddella.service.RentalServiceImp;

public class RentalUtility {

	public static void main(String[] args) {
		rentalMenu();
	}

	public static void rentalMenu() {
		char selectChoice;
		do {
			Scanner scanner = new Scanner(System.in);

			System.out.println("1.Add  Rental \n2.Display All Rental\n3.Update Rental\n4.Search Rental");
			int choice = scanner.nextInt();
			if (choice == 1) {
				addRental();

			} else if (choice == 2) {
				displayAllRental();

			} else if (choice == 3) {
				updateRentalDetails();
			} else if (choice == 4) {
				searchRental();
			}
			System.out.println("do you want continue");
			selectChoice = scanner.next().charAt(0);
		} while (selectChoice == 'y' || selectChoice == 'Y');
	}

	public static Rental searchRental() {

		RentalServiceImp rentalServiceImp = new RentalServiceImp();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Rental_id: ");
		String rentalId = scanner.nextLine();
		Rental rental = rentalServiceImp.searchRental(rentalId);

		if (rental != null) {

			System.out.println(rental.getRental_id() + "   " + rental.getVehicle().getVehicle_Id() + "    "
					+ rental.getCost_per_hour());
		} else {
			System.out.println("Rental ID not found.");

		}
		return rental;
	}

	private static void updateRentalDetails() {
		RentalServiceImp rentalServiceImp = new RentalServiceImp();

		Scanner scanner = new Scanner(System.in);
		Rental rental = searchRental();

		if (rental != null) {
			System.out.println("1.update Cost_per_hour :");
			int updateChoice = scanner.nextInt();

			if (updateChoice == 1) {
				scanner.nextLine();
				System.out.println("Enter the Type : ");
				int updateCost_Per_Hour = scanner.nextInt();
				rental.setCost_per_hour(updateCost_Per_Hour);

				rentalServiceImp.updateRental(rental);

			}
		}
	}

	public static void displayAllRental() {
		RentalServiceImp rentalServiceImp = new RentalServiceImp();
		List<Rental> rentalList = rentalServiceImp.listAllRental();
		for (Rental ren : rentalList) {
			System.out.println(
					ren.getRental_id() + "   " + ren.getVehicle().getVehicle_Id() + "    " + ren.getCost_per_hour());

		}
	}

	private static void addRental() {
		RentalServiceImp rentalServiceImp = new RentalServiceImp();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Rental_id : ");
		String rental_id = scanner.nextLine();
		VehicleUtility.displayAllVehicle();
		System.out.println("Enter the Vehicle_id : ");
		String vehicle_id = scanner.nextLine();
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicle_Id(vehicle_id);
		System.out.println("Enter the Cost_Per_Hour : ");
		int cost_Per_Hour = scanner.nextInt();
		rentalServiceImp.addRental(new Rental(rental_id, cost_Per_Hour, vehicle));
	}
	

	public static Rental searchRental(String vehicle_id) {
		RentalServiceImp rentalServiceImp = new RentalServiceImp();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Rental_id: ");
		String rentalId = scanner.nextLine();
		Rental rental = rentalServiceImp.searchRental(rentalId);

		if (rental != null) {

			System.out.println(rental.getRental_id() + "   " + rental.getVehicle().getVehicle_Id() + "    "
					+ rental.getCost_per_hour());
		} else {
			System.out.println("Rental ID not found.");

		}
		return rental;
	}

}
