package com.canddella.utility;

import java.util.ArrayList;
import java.util.Scanner;

import com.canddella.entity.Vehicle;
import com.canddella.entity.VehicleType;
import com.canddella.service.VehicleTypeServiceImp;

public class VehicleTypeUtility {
	public static void main(String[] args) {
		vehicleTypeMenu();
	}

	public static void vehicleTypeMenu() {
		char selectChoice;
		do {
			Scanner scanner = new Scanner(System.in);

			System.out.println("1.Display All Vehicle");
			int choice = scanner.nextInt();
			if (choice == 1) {
				
				displayAllVehicleType();
			} 

			System.out.println("do you want continue");
			selectChoice = scanner.next().charAt(0);
		} while (selectChoice == 'y' || selectChoice == 'Y');
	}

	public static void displayAllVehicleType() {
		VehicleTypeServiceImp vehicleTypeServiceImp = new VehicleTypeServiceImp();
		ArrayList<VehicleType> vehicleTypeList;
		vehicleTypeList = (ArrayList<VehicleType>) vehicleTypeServiceImp.ListAllVehicle();
		   System.out.println("Vehicle_Type" + "       " + "Description");
		   for (VehicleType vehiclety : vehicleTypeList) {
			
			System.out.println(
					vehiclety.getVehicleType_id() + "                   " + vehiclety.getDescription());
						
		}
	}
		
	}

