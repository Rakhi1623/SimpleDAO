package com.canddella.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Booking;
import com.canddella.entity.Customer;
import com.canddella.entity.Drivers;
import com.canddella.entity.DriversBooking;
import com.canddella.entity.ReferralDiscounts;
import com.canddella.entity.Vehicle;
import com.canddella.entity.VehicleType;
import com.canddella.service.BookingServiceImp;
import com.canddella.service.CustomerServiceImp;
import com.canddella.service.DriversBookingSericeImp;
import com.canddella.service.LoyaltyPointsServiceImp;
import com.canddella.service.ReferralDiscountsServiceImp;
import com.canddella.service.VehicleServiceImp;

public class BookingUtility {

	public static void main(String[] args) {
		bookingMenu();
	}

	public static void bookingMenu() {
		char selectChoice;
		do {
			Scanner scanner = new Scanner(System.in);

			System.out.println("1.Add  Booking \n2.Display All Booking\n3.Update Booking\n4.Search Booking");
			int choice = scanner.nextInt();
			if (choice == 1) {
				addBooking();

			} else if (choice == 2) {
				displayAllBooking();

			} else if (choice == 3) {
				updateBookingDetails();

			} else if (choice == 4) {
				searchBooking();
			}

			System.out.println("do you want continue");
			selectChoice = scanner.next().charAt(0);
		} while (selectChoice == 'y' || selectChoice == 'Y');
	}

	private static void getAllBookingBasedONDate() {
		BookingServiceImp bookingServiceImp = new BookingServiceImp();
		VehicleServiceImp vehicleServiceImp = new VehicleServiceImp();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Actual_date: ");
		String actual_date = scanner.nextLine();

		LocalDate nUpdateActualDate = LocalDate.parse(actual_date, formatter);
		List<Booking> bookingsList = bookingServiceImp.getAllBookingBasedOnDate(nUpdateActualDate);
		List<Vehicle> vehicleList = vehicleServiceImp.ListAllVehicle();
		List<Vehicle> vehicleNotBooked = new ArrayList<>(vehicleList);

		for (Booking booking : bookingsList) {
			vehicleNotBooked.removeIf(vehicle -> vehicle.getVehicle_Id().equals(booking.getVehicle().getVehicle_Id()));
		}

		if (!vehicleNotBooked.isEmpty()) {
			System.out.println("Vehicles not booked on " + actual_date + ":");
			for (Vehicle vehicle : vehicleNotBooked) {
				System.out.println("Vehicle ID: " + vehicle.getVehicle_Id());
				System.out.println("Vehicle TYPE: " + vehicle.getVehicle_Type());
				System.out.println("Vehicle brand: " + vehicle.getVehicle_brand());
				System.out.println("Vehicle model: " + vehicle.getVehicle_Model());
				System.out.println("Vehicle Year : " + vehicle.getVehicle_Type());
				System.out.println("Vehicle Capacity: " + vehicle.getVehicle_Capacity());
				System.out.println("Vehicle Colour: " + vehicle.getVehicle_Colour());

				System.out.println("----------------------------------");
			}
		} else {
			System.out.println("All vehicles are booked on " + actual_date + ".");
		}
	}

	public static Booking searchBooking() {
		BookingServiceImp bookingServiceImp = new BookingServiceImp();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Booking_id: ");
		String booking_id = scanner.nextLine();
		Booking booking = bookingServiceImp.searchBooking(booking_id);

		if (booking != null) {
			System.out.println(booking.getBooking_id() + "   " + booking.getCustomer().getCustomer_id() + "    "
					+ booking.getVehicle().getVehicle_Id() + "    " + booking.getBooking_date() + "     "
					+ booking.getAcutal_date());
		} else {
			System.out.println("Booking not found with the given booking ID.");
		}

		return booking;
	}

	private static void updateBookingDetails() {
		BookingServiceImp bookingServiceImp = new BookingServiceImp();
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		Scanner scanner = new Scanner(System.in);
		Booking booking = searchBooking();
		if (booking != null) {
			System.out.println("1.update Booking Date\n2.update Actual Date:");
			int updateChoice = scanner.nextInt();

			if (updateChoice == 1) {
				scanner.nextLine();
				System.out.println("Enter the Booking Date : ");
				String updateBookingDate = scanner.nextLine();
				LocalDate nUpdateBookingDate = LocalDate.parse(updateBookingDate, formater);
				booking.setBooking_date(nUpdateBookingDate);

				bookingServiceImp.updateBooking(booking);
			}

			else if (updateChoice == 2) {
				scanner.nextLine();
				System.out.println("Enter the Actual Date  : ");
				String updateActualDate = scanner.nextLine();
				LocalDate nUpdateActualDate = LocalDate.parse(updateActualDate, formater);
				booking.setAcutal_date(nUpdateActualDate);

				bookingServiceImp.updateBooking(booking);
			}

		}
	}

	void getBookedDetails() {
	}

	public static void displayAllBooking() {
		BookingServiceImp bookingServiceImp = new BookingServiceImp();
		List<Booking> bookingList = bookingServiceImp.ListAllBooking();
		for (Booking booking : bookingList) {
			System.out.println(booking.getBooking_id() + "   " + booking.getCustomer().getCustomer_id() + "    "
					+ booking.getVehicle().getVehicle_Id() + "      " + booking.getVehicleType().getVehicleType_id()
					+ "    " + booking.getBooking_date() + "     " + booking.getAcutal_date());

		}
	}

	private static void addBooking() {
		BookingServiceImp bookingServiceImp = new BookingServiceImp();
		LoyaltyPointsServiceImp loyaltyPointsServiceImp = new LoyaltyPointsServiceImp();
		DriversBookingSericeImp driversBookingServiceImp = new DriversBookingSericeImp();
		ReferralDiscountsServiceImp referralDiscountServiceImp = new ReferralDiscountsServiceImp();

		List<Booking> bookings;
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the Booking_id");
		String booking_id = scanner.nextLine();
		CustomerUtility.displayAllCustomer();
		System.out.println("Enter the Customer_id");
		String customer_id = scanner.nextLine();
		Customer customer = new Customer();
		customer.setCustomer_id(customer_id);

		System.out.println("Are you a referral customer? (Enter 'yes' or 'no')");
		String isReferralCustomer = scanner.nextLine();

		if (isReferralCustomer.equalsIgnoreCase("yes")) {
			System.out.println("Enter the referring Customer_id:");
			String referringCustomer_id = scanner.nextLine();

			CustomerServiceImp customerServiceImpl = new CustomerServiceImp();
			Customer customerR = customerServiceImpl.searchCustomer(referringCustomer_id);

			System.out.println("Enter the ReferralDiscount_id:");
			String referralDiscount_id = scanner.nextLine();

			VehicleTypeUtility.displayAllVehicleType();
			System.out.println("Enter the VehicleType_id");
			String vehicleType_id = scanner.nextLine();
			VehicleType vehicleType = new VehicleType();
			vehicleType.setVehicleType_id(vehicleType_id);

			getAllBookingBasedONDate();
			List<Vehicle> vehicleNotBooked = new ArrayList<>();
			for (Vehicle veh : vehicleNotBooked) {
				System.out.println(veh);
			}

			System.out.println("Enter the Vehicle_id");
			String vehicle_id = scanner.nextLine();
			Vehicle vehicle = new Vehicle();
			vehicle.setVehicle_Id(vehicle_id);

			System.out.println("Do you want a driver? (Enter 'yes' or 'no')");
			String wantDriver = scanner.nextLine();
			boolean driverRequested = false;

			if (wantDriver.equalsIgnoreCase("yes")) {
				driverRequested = true;
				DriversBookingUtility.getAllDriversBookingBasedONDate();
				List<Drivers> driversNotBooked = new ArrayList<>();
				for (Drivers drive : driversNotBooked) {
					System.out.println(drive);
				}
				if (driversNotBooked != null) {
					System.out.println("Enter the driver_id");
					String driver_id = scanner.nextLine();

					Drivers driver = new Drivers();
					driver.setDriver_Id(driver_id);
					System.out.println("Enter the DriversBooking_id");
					String driversBooking_id = scanner.nextLine();

					System.out.println("Enter the Booking_date");
					String booking_date = scanner.nextLine();
					System.out.println("Enter the Actual_date");
					String actual_date1 = scanner.nextLine();

					LocalDate nActual_date = LocalDate.parse(actual_date1, formater);
					LocalDate nBooking_date = LocalDate.parse(booking_date, formater);

					bookingServiceImp.addBooking(
							new Booking(booking_id, nBooking_date, nActual_date, customer, vehicle, vehicleType));

					if (driverRequested && driver != null) {

						Booking booking = bookingServiceImp.searchBooking(booking_id);

						if (booking != null) {
							driversBookingServiceImp.addDriversBooking(
									new DriversBooking(driversBooking_id, nActual_date, booking, driver));
						} else {
							System.out.println("Booking with ID " + booking_id + " not found.");

						}

						ReferralDiscounts referralDiscount1 = new ReferralDiscounts(referralDiscount_id, true, booking,
								customerR);

						referralDiscountServiceImp.addReferralDiscount(referralDiscount1);

						System.out.println("Referral discount added for the referring customer.");

						if (loyaltyPointsServiceImp.doesCustomerExist(customer_id)) {
							loyaltyPointsServiceImp.updateLoyaltyPoints(customer_id);
							System.out.println("Loyalty points updated for customer: " + customer_id);
						} else {
							loyaltyPointsServiceImp.addLoyaltyPoints(customer_id);
							System.out.println("Loyalty points added for new customer: " + customer_id);
						}

					}

				}
			}
			else if(wantDriver.equalsIgnoreCase("no")) {
				driverRequested = false;
				System.out.println("Enter the Booking_date");
				String booking_date = scanner.nextLine();
				System.out.println("Enter the Actual_date");
				String actual_date1 = scanner.nextLine();

				LocalDate nActual_date = LocalDate.parse(actual_date1, formater);
				LocalDate nBooking_date = LocalDate.parse(booking_date, formater);

				bookingServiceImp.addBooking(
						new Booking(booking_id, nBooking_date, nActual_date, customer, vehicle, vehicleType));

				
					Booking booking = bookingServiceImp.searchBooking(booking_id);

				
					ReferralDiscounts referralDiscount1 = new ReferralDiscounts(referralDiscount_id, true, booking,
							customerR);

					referralDiscountServiceImp.addReferralDiscount(referralDiscount1);

					System.out.println("Referral discount added for the referring customer.");

					if (loyaltyPointsServiceImp.doesCustomerExist(customer_id)) {
						loyaltyPointsServiceImp.updateLoyaltyPoints(customer_id);
						System.out.println("Loyalty points updated for customer: " + customer_id);
					} else {
						loyaltyPointsServiceImp.addLoyaltyPoints(customer_id);
						System.out.println("Loyalty points added for new customer: " + customer_id);
					}

				}

			}
		
			else if (isReferralCustomer.equalsIgnoreCase("no")) {
				VehicleTypeUtility.displayAllVehicleType();
				System.out.println("Enter the VehicleType_id");
				String vehicleType_id = scanner.nextLine();
				VehicleType vehicleType = new VehicleType();
				vehicleType.setVehicleType_id(vehicleType_id);

				getAllBookingBasedONDate();
				List<Vehicle> vehicleNotBooked = new ArrayList<>();
				for (Vehicle veh : vehicleNotBooked) {
					System.out.println(veh);
				}

				System.out.println("Enter the Vehicle_id");
				String vehicle_id = scanner.nextLine();
				Vehicle vehicle = new Vehicle();
				vehicle.setVehicle_Id(vehicle_id);

				System.out.println("Do you want a driver? (Enter 'yes' or 'no')");
				String wantDriver = scanner.nextLine();
				boolean driverRequested = false;

				if (wantDriver.equalsIgnoreCase("yes")) {
					driverRequested = true;
					DriversBookingUtility.getAllDriversBookingBasedONDate();
					List<Drivers> driversNotBooked = new ArrayList<>();
					for (Drivers drive : driversNotBooked) {
						System.out.println(drive);
					}
					if (driversNotBooked != null) {
						System.out.println("Enter the driver_id");
						String driver_id = scanner.nextLine();

						Drivers driver = new Drivers();
						driver.setDriver_Id(driver_id);
						System.out.println("Enter the DriversBooking_id");
						String driversBooking_id = scanner.nextLine();

						System.out.println("Enter the Booking_date");
						String booking_date = scanner.nextLine();
						System.out.println("Enter the Actual_date");
						String actual_date1 = scanner.nextLine();

						LocalDate nActual_date = LocalDate.parse(actual_date1, formater);
						LocalDate nBooking_date = LocalDate.parse(booking_date, formater);

						bookingServiceImp.addBooking(
								new Booking(booking_id, nBooking_date, nActual_date, customer, vehicle, vehicleType));

						if (driverRequested && driver != null) {

							Booking booking = bookingServiceImp.searchBooking(booking_id);

							if (booking != null) {
								driversBookingServiceImp.addDriversBooking(
										new DriversBooking(driversBooking_id, nActual_date, booking, driver));
							} else {
								System.out.println("Booking with ID " + booking_id + " not found.");

							}
						

							System.out.println("Referral discount added for the referring customer.");

							if (loyaltyPointsServiceImp.doesCustomerExist(customer_id)) {
								loyaltyPointsServiceImp.updateLoyaltyPoints(customer_id);
								System.out.println("Loyalty points updated for customer: " + customer_id);
							} else {
								loyaltyPointsServiceImp.addLoyaltyPoints(customer_id);
								System.out.println("Loyalty points added for new customer: " + customer_id);
							}

						}

					}
				}
				else if (wantDriver.equalsIgnoreCase("no")) {
					System.out.println("Enter the Booking_date");
					String booking_date = scanner.nextLine();
					System.out.println("Enter the Actual_date");
					String actual_date1 = scanner.nextLine();

					LocalDate nActual_date = LocalDate.parse(actual_date1, formater);
					LocalDate nBooking_date = LocalDate.parse(booking_date, formater);

					bookingServiceImp.addBooking(
							new Booking(booking_id, nBooking_date, nActual_date, customer, vehicle, vehicleType));

//					if (driverRequested && driver != null) {
//
//						Booking booking = bookingServiceImp.searchBooking(booking_id);
//
//						if (booking != null) {
//							driversBookingServiceImp.addDriversBooking(
//									new DriversBooking(driversBooking_id, nActual_date, booking, driver));
//						} else {
//							System.out.println("Booking with ID " + booking_id + " not found.");
//
//						}
					

						System.out.println("Referral discount added for the referring customer.");

						if (loyaltyPointsServiceImp.doesCustomerExist(customer_id)) {
							loyaltyPointsServiceImp.updateLoyaltyPoints(customer_id);
							System.out.println("Loyalty points updated for customer: " + customer_id);
						} else {
							loyaltyPointsServiceImp.addLoyaltyPoints(customer_id);
							System.out.println("Loyalty points added for new customer: " + customer_id);
						}

					}

				}
			}
				
			

			
	public static Booking searchBooking(String booking_id) {
		BookingServiceImp bookingServiceImp = new BookingServiceImp();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Booking_id: ");
		String booking_id1 = scanner.nextLine();
		Booking booking = bookingServiceImp.searchBooking(booking_id1);

		if (booking != null) {
			System.out.println("Booking_id :" + booking.getBooking_id() + "   " + "Customer_Id : "
					+ booking.getCustomer().getCustomer_id() + "    " + "Vehicle_id : "
					+ booking.getVehicle().getVehicle_Id() + "    " + "Booking_Date : " + booking.getBooking_date()
					+ "     " + "Acutal Date : " + booking.getAcutal_date());
		} else {
			System.out.println("Booking not found with the given booking ID.");
		}

		return booking;
	}

}
