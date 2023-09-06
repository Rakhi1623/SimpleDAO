package com.canddella.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import com.canddella.entity.Customer;
import com.canddella.entity.Drivers;
import com.canddella.service.CustomerServiceImp;
import com.canddella.service.DriversServiceImp;

public class DriversUtility {

	public static void main(String[] args) {
		
			
			driverMenu();
		}
		
		public static void driverMenu() {
			char selectChoice;
			do {
				
				Scanner scanner = new Scanner(System.in);
				
				System.out.println("1.Add Drivers \n2.Display All Drivers\n3.Update Drivers Details\n4.Search Drivers");
				int choice = scanner.nextInt();
			
		
			 if(choice==1)
			 {
				 addDrivers();
			 }
			 else if (choice==2) {
				 displayAllDrivers();
				 }
			 else if (choice==3) {
				 updateDriversDetails();
				 }
			 else if (choice==4) {
				  searchDrivers();
			 }
				  
			 System.out.println("do you want continue");
	         selectChoice = scanner.next().charAt(0);
			}while(selectChoice=='y'||selectChoice=='Y');
		}

		public static Drivers searchDrivers() {
			DriversServiceImp driverServiceImp = new DriversServiceImp();
			Scanner scanner = new Scanner(System.in);
			 System.out.println("Enter the Drivers_id: ");
			 String drivers_id = scanner.nextLine();
			 Drivers driver = driverServiceImp.searchDrivers( drivers_id);
			    
		          if (driver != null) {
		        	  
		                System.out.println( driver.getDriver_Id() + "   " + driver.getDriver_firstName()+"   "+driver.getDriver_lastName()+"   "+driver.getDriver_dob()+"     "+driver.getDriver_address()+"   "+driver.getDriver_phoneNo()+"    "+driver.getDriver_adharNo());
		        } else {
		            System.out.println("Driver ID not found.");

			}
		          return driver;
		}

		

		private static void updateDriversDetails() {
			DriversServiceImp driverServiceImp = new DriversServiceImp();

			DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			
			Scanner scanner = new Scanner(System.in);
			
			 Drivers driver  =  searchDrivers();
			 
				 if(driver!= null){
					System.out.println("1.Update Driver_firstName\n2.Update Driver_lastName\n3.Update Driver_dob\n4.Update Driver_address\n5.Update Driver_phoneNo\n6.Update Driver_adharNo");
					int updateChoice = scanner.nextInt();
					if(updateChoice==1) {
						System.out.println("Enter the Driver_firstName: ");
						String updateDriver_firstName = scanner.nextLine();
						driver.setDriver_Id(updateDriver_firstName);
					}
					else if(updateChoice==2) {
						System.out.println("Enter the Driver_lasttName: ");
						String updateDriver_lastName = scanner.nextLine();
						driver.setDriver_lastName(updateDriver_lastName);
					}
					else if(updateChoice==3) {
						System.out.println("Enter the Driver_dob: ");
						String updateDriver_dob = scanner.nextLine();
						 LocalDate nUpdateDriver_dob = LocalDate.parse(updateDriver_dob, formater);

						driver.setDriver_dob(nUpdateDriver_dob);
					}
					else if(updateChoice==4) {
						System.out.println("Enter the Driver_address: ");
						String updateDriver_address = scanner.nextLine();
						driver.setDriver_address(updateDriver_address);
					}
					else if(updateChoice==5) {
						System.out.println("Enter the Driver_phoneno: ");
						long updateDriver_phoneno = scanner.nextLong();
						driver.setDriver_phoneNo(updateDriver_phoneno);
					}
					
					else if(updateChoice==6) {
						System.out.println("Enter the Driver_adharNo: ");
						long updateDriver_adharNo = scanner.nextLong();
						driver.setDriver_adharNo(updateDriver_adharNo);
					}
				
					driverServiceImp.updateDrivers(driver);;
				 }
					
			 } 
		
			
		

		public static void displayAllDrivers() {
			DriversServiceImp driverServiceImp = new DriversServiceImp();

	      	  ArrayList<Drivers>driverList;
	      	driverList=(ArrayList<Drivers>)driverServiceImp.listAllDrivers();
	      	  for(Drivers dri : driverList)
	      	  {
	                System.out.println( dri.getDriver_Id() + "   " + dri.getDriver_firstName()+"   "+dri.getDriver_lastName()+"   "+dri.getDriver_dob()+"     "+dri.getDriver_address()+"   "+dri.getDriver_phoneNo()+"    "+dri.getDriver_adharNo());

	      	  }
			
		}

		private static void addDrivers() {
			DriversServiceImp driverServiceImp = new DriversServiceImp();
			Scanner scanner = new Scanner(System.in);
			DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	  		System.out.println("Enter the Driver_id : ");
	  		String  driver_id = scanner.nextLine();
	  		System.out.println("Enter the Driver_firstname : ");
	  		 String driver_firstname= scanner.nextLine();
	  		System.out.println("Enter the  Driver_lastname : ");
	 		 String driver_lastname= scanner.nextLine();
	 		System.out.println("Enter the  Driver_dob  (yyyy-MM-dd) : ");
			 String driver_dob= scanner.nextLine();
	 		System.out.println("Enter the Driver_address:");
	        String driver_address = scanner.nextLine();
	        
	        System.out.println("Enter the Driver_phoneNo : ");
			 long driver_phoneNo= scanner.nextLong();
			 scanner.nextLine();
			 
			 System.out.println("Enter the Driver_adharNo : ");
			 long driver_adharNo= scanner.nextLong();
			 
			 LocalDate nDriver_dob = LocalDate.parse(driver_dob,formater);
			 driverServiceImp.addDrivers(new Drivers(driver_id,driver_firstname,driver_lastname,nDriver_dob,driver_address,driver_phoneNo,driver_adharNo));
			
			System.out.println("New Driver Added successfully.");
			

			
		}
		
		

	}


