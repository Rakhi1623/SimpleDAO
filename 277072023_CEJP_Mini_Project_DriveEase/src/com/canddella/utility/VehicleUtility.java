package com.canddella.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Customer;
import com.canddella.entity.Vehicle;
import com.canddella.service.VehicleServiceImp;

public class VehicleUtility {

	public static void main(String[] args) {
		vehicleMenu();
	}

	public static void vehicleMenu() {
		char selectChoice;
		do {
			Scanner scanner = new Scanner(System.in);

			System.out.println("1.Add  Vehicle \n2.Display All Vehicle\n3.Update Vehicle\n4.Search Vehicle");
			int choice = scanner.nextInt();
			if (choice == 1) {
				addVehicle();

			} else if (choice == 2) {
				displayAllVehicle();
			} else if (choice == 3) {
				updateVehicleDetails();
			} else if (choice == 4) {
				searchVehicle();
			}

			System.out.println("do you want continue");
			selectChoice = scanner.next().charAt(0);
		} while (selectChoice == 'y' || selectChoice == 'Y');
	}

	public static Vehicle searchVehicle() {
		VehicleServiceImp vehicleServiceImp = new VehicleServiceImp();
		Scanner scanner = new Scanner(System.in);
		 System.out.println("Enter the Vehicle_id: ");
		 String vehicle_id = scanner.nextLine();
			Vehicle vehicle = vehicleServiceImp.searchVehicle(vehicle_id);
		    
	          if ( vehicle_id!= null) {
	        	  System.out.println(
	        			  vehicle.getVehicle_Id() + "          " + vehicle.getVehicle_Type() + "           " + vehicle.getVehicle_brand()
	  							+ "           " + vehicle.getVehicle_Model() + "             " + vehicle.getVehicle_year()
	  								+ "         " + vehicle.getVehicle_Capacity() + "           " + vehicle.getVehicle_Colour());
	          }
	          return vehicle;
	        	
	}
	

	public static void updateVehicleDetails() {
		VehicleServiceImp vehicleServiceImp = new VehicleServiceImp();
	
		Scanner scanner = new Scanner(System.in);
		Vehicle vehicle = searchVehicle() ;
		
			if (vehicle!=null) {
				System.out.println(
						"1.update the type: \n2.update the brand  :\n3.update the model : \n4.update the year: \n5.update the capacity :\n6.update the colour");
				int updateChoice = scanner.nextInt();

				if (updateChoice == 1) {
					scanner.nextLine();
					System.out.println("Enter the Type : ");
					String updateVehicleType = scanner.nextLine();
					vehicle.setVehicle_Type(updateVehicleType);
				} else if (updateChoice == 2) {
					scanner.nextLine();
					System.out.println("Enter the Brand : ");
					String updateVehicleBrand = scanner.nextLine();
					vehicle.setVehicle_brand(updateVehicleBrand);
				} else if (updateChoice == 3) {
					scanner.nextLine();
					System.out.println("Enter the Model : ");
					String updateVehicleModel = scanner.nextLine();
					vehicle.setVehicle_Model(updateVehicleModel);
				} else if (updateChoice == 4) {
					scanner.nextLine();
					System.out.println("Enter the Year : ");
					String updateVehicleYear = scanner.nextLine();
					vehicle.setVehicle_year(updateVehicleYear);
					;
				} else if (updateChoice == 5) {
					scanner.nextLine();
					System.out.println("Enter the Capacity : ");
					int updateVehicleCapacity = scanner.nextInt();
					vehicle.setVehicle_Capacity(updateVehicleCapacity);
				} else if (updateChoice == 6) {
					scanner.nextLine();
					System.out.println("Enter the Colour : ");
					String updateVehicleColour = scanner.nextLine();
					vehicle.setVehicle_Colour(updateVehicleColour);
				}
				vehicleServiceImp.updateVehicle(vehicle);

			}
		}
	

	public static void displayAllVehicle() {

		VehicleServiceImp vehicleServiceImp = new VehicleServiceImp();
		ArrayList<Vehicle> vehicleList;
		vehicleList = (ArrayList<Vehicle>) vehicleServiceImp.ListAllVehicle();
		System.out.println(
				"Vehicle_id" + "   " + "Vehicle_Type" + "     " + "Vehicle_brand" + "    " + "Vehicle_model"
						+ "    " + "   " + "Vehicle_Year" + "   " + "Vehicle_Cpacity" + "     " + "Vehicle_Colour");
		for (Vehicle veh : vehicleList) {
			
			
			System.out.print("   ");
			System.out.println(
					veh.getVehicle_Id() + "          " + veh.getVehicle_Type() + "           " + veh.getVehicle_brand()
							+ "           " + veh.getVehicle_Model() + "             " + veh.getVehicle_year()
							+ "         " + veh.getVehicle_Capacity() + "           " + veh.getVehicle_Colour());

		}
	}

	public static void addVehicle() {
		VehicleServiceImp vehicleServiceImp = new VehicleServiceImp();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Vehicle_id : ");
		String vehicle_id = scanner.nextLine();
		VehicleTypeUtility.displayAllVehicleType();
		System.out.println("Enter the Vehicle_Type : ");
		String vehicle_Type = scanner.nextLine();
		System.out.println("Enter the Vehicle_brand : ");
		String vehicle_Brand = scanner.nextLine();
		System.out.println("Enter the Vehicle_model : ");
		String vehicle_Model = scanner.nextLine();
		System.out.println("Enter the Vehicle_year : ");
		String vehicle_Year = scanner.nextLine();
		System.out.println("Enter the Vehicle_capacity : ");
		int vehicle_Capacity = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Vehicle_colour : ");
		String vehicle_Colour = scanner.nextLine();
		vehicleServiceImp.addVehicle(new Vehicle(vehicle_id, vehicle_Type, vehicle_Brand, vehicle_Model, vehicle_Year,
				vehicle_Capacity, vehicle_Colour));
	}

	public static void displayAllVehicle(List<Vehicle> availableVehicles) {

		VehicleServiceImp vehicleServiceImp = new VehicleServiceImp();
		ArrayList<Vehicle> vehicleList;
		vehicleList = (ArrayList<Vehicle>) vehicleServiceImp.ListAllVehicle();
		System.out.println(
				"Vehicle_id" + "   " + "Vehicle_Type" + "     " + "Vehicle_brand" + "    " + "Vehicle_model"
						+ "    " + "   " + "Vehicle_Year" + "   " + "Vehicle_Cpacity" + "     " + "Vehicle_Colour");
		for (Vehicle veh : vehicleList) {
			
			
			System.out.print("   ");
			System.out.println(
					veh.getVehicle_Id() + "          " + veh.getVehicle_Type() + "           " + veh.getVehicle_brand()
							+ "           " + veh.getVehicle_Model() + "             " + veh.getVehicle_year()
							+ "         " + veh.getVehicle_Capacity() + "           " + veh.getVehicle_Colour());

		}
	}

		
	}
