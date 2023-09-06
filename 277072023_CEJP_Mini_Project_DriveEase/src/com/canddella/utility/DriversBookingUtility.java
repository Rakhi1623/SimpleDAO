package com.canddella.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Booking;
import com.canddella.entity.Drivers;
import com.canddella.entity.DriversBooking;
import com.canddella.service.DriversBookingSericeImp;
import com.canddella.service.DriversServiceImp;

public class DriversBookingUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		driverBookingMenu();
	}

	public static void driverBookingMenu() {
		char selectChoice;
		do {

			Scanner scanner = new Scanner(System.in);

			System.out.println(
					"1.Add DriversBooking\n2.Display All DriversBooking\n3.Update DriversBooking Details\n4.Search DriversBooking");
			int choice = scanner.nextInt();

			if (choice == 1) {
				addDriversBooking();
			} else if (choice == 2) {
				displayAllDriversBooking();
			} else if (choice == 3) {
				updateDriversBookingDetails();
			} else if (choice == 4) {
				searchDriversBooking();
			}

			System.out.println("do you want continue");
			selectChoice = scanner.next().charAt(0);
		} while (selectChoice == 'y' || selectChoice == 'Y');
	}

	private static void searchDriversBooking() {
		// TODO Auto-generated method stub

	}

	private static void updateDriversBookingDetails() {
		// TODO Auto-generated method stub

	}

	private static void displayAllDriversBooking() {
		DriversBookingSericeImp driversBookingSericeImp = new DriversBookingSericeImp();

		ArrayList<DriversBooking> driverBookingList;
		driverBookingList = (ArrayList<DriversBooking>) driversBookingSericeImp.listAllDriversBooking();
		for (DriversBooking driverBook : driverBookingList) {
			System.out.println(driverBook.getDriversBooking_id() + "   " + driverBook.getBooking().getBooking_id()
					+ "   " + driverBook.getDriver().getDriver_Id() + "   " + driverBook.getActual_date());

		}

	}

	public static void addDriversBooking() {
		DriversBookingSericeImp driversBookingSericeImp = new DriversBookingSericeImp();

		Scanner scanner = new Scanner(System.in);
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		System.out.println("Enter the DriverBooking_id : ");
		String driverBooking_id = scanner.nextLine();
		System.out.println("Enter the Booking_id : ");
		String Booking_id = scanner.nextLine();
		Booking booking = new Booking();
		BookingUtility.searchBooking(Booking_id);
		booking.setBooking_id(Booking_id);
		System.out.println("Enter the  Driver_id : ");
		String driver_id = scanner.nextLine();
		Drivers driver = new Drivers();
		driver.setDriver_Id(driver_id);
		booking.getAcutal_date();
		System.out.println("Enter the  Actual_Date  (yyyy-MM-dd) : ");
		String actual_Date = scanner.nextLine();

		LocalDate nActual_Date = LocalDate.parse(actual_Date, formater);
		driversBookingSericeImp.addDriversBooking(new DriversBooking(driverBooking_id, nActual_Date, booking, driver));

		System.out.println("New DriversBooking Added successfully.");

	}

	public static void getAllDriversBookingBasedONDate() {

		DriversBookingSericeImp driversBookingServiceImp = new DriversBookingSericeImp();
		DriversServiceImp driversServiceImp = new DriversServiceImp();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Actual_date: ");
		String actual_date = scanner.nextLine();

		LocalDate nUpdateActualDate = LocalDate.parse(actual_date, formatter);

		List<Drivers> driverList = driversServiceImp.listAllDrivers(); // You need to implement getAllDrivers method
		List<DriversBooking> driversBookingList = driversBookingServiceImp
				.getAllDriversBookingBasedOnDate(nUpdateActualDate);
		List<Drivers> driversNotBooked = new ArrayList<>(driverList);

		for (DriversBooking driverBooking : driversBookingList) {
			driversNotBooked.removeIf(driver -> driver.getDriver_Id().equals(driverBooking.getDriver().getDriver_Id()));
		}

		if (!driversNotBooked.isEmpty()) {
			System.out.println("Drivers not booked on " + actual_date + ":");
			for (Drivers driver : driversNotBooked) {
				System.out.println("Driver ID: " + driver.getDriver_Id());
				System.out.println("Driver firstName: " + driver.getDriver_firstName());
				System.out.println("Driver lastName: " + driver.getDriver_lastName());
				System.out.println("Driver Dob: " + driver.getDriver_dob());
				System.out.println("Driver address: " + driver.getDriver_address());
				System.out.println("Driver phoneno: " + driver.getDriver_phoneNo());
				System.out.println("Driver adharno: " + driver.getDriver_adharNo());

				System.out.println("----------------------------------");
			}
		} else {
			System.out.println("All drivers are booked on " + actual_date + ".");
		}
	}

}
