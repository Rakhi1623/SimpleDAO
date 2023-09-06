package com.canddella.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import com.canddella.entity.Customer;
import com.canddella.entity.User;
import com.canddella.service.CustomerServiceImp;
import com.canddella.service.UserServiceImp;

public class UserUtility {

	public static void main(String[] args) {
		userMenu();
	}

	private static void userMenu() {
		char selectChoice;
		do {

			Scanner scanner = new Scanner(System.in);

			System.out.println("1.Add User \n2.Display All User\n3.Update User Details\n4.Search User");
			int choice = scanner.nextInt();

			if (choice == 1) {
				addUser();
			} else if (choice == 2) {
				displayAllUser();
			} else if (choice == 3) {
				updateUserDetails();
			} else if (choice == 4) {
				searchUser();
			}

			System.out.println("do you want continue");
			selectChoice = scanner.next().charAt(0);
		} while (selectChoice == 'y' || selectChoice == 'Y');
	}

	private static User searchUser() {
		UserServiceImp userServiceImp = new UserServiceImp();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the User_id: ");
		String userId = scanner.nextLine();
		User user = userServiceImp.searchUser(userId);

		if (user != null) {

			System.out.println(user.getUser_id() + " " +user.getUser_Name()
					+ "    " + user.getEmail()+ "     " + user.getPhoneNo());
					
		} else {
			System.out.println("User ID not found.");

		}
		return user;
	}

	

	private static void updateUserDetails() {
		UserServiceImp userServiceImp = new UserServiceImp();
	
		Scanner scanner = new Scanner(System.in);
		
		User user = searchUser();
		 
			 if(user!= null){
				System.out.println("1.Update User_name\n2.Update Email\n3.Update PhoneNo");
				int updateChoice = scanner.nextInt();
				
				 if(updateChoice==1) {
					System.out.println("Enter the User_name: ");
					String updateUser_Name = scanner.nextLine();
					user.setUser_Name(updateUser_Name);
				}
				else if(updateChoice==2) {
					System.out.println("Enter the Email: ");
					String updateEmail = scanner.nextLine();
					user.setEmail(updateEmail);
				}
				else if(updateChoice==3) {
					System.out.println("Enter the PhoneNo: ");
					Long updatePhoneNo = scanner.nextLong();
					user.setPhoneNo(updatePhoneNo);
			
			
			 }
				 userServiceImp.updateUser(user);
		 } 
	

	}

	private static void displayAllUser() {
		UserServiceImp userServiceImp = new UserServiceImp();

		ArrayList<User> userList;
		userList = (ArrayList<User>) userServiceImp.ListAllUser();
		for (User use : userList) {
			System.out.println(
					use.getUser_id() + "   " + use.getUser_Name() + "   " + use.getEmail() + "   " + use.getPhoneNo());

		}

	}

	private static void addUser() {

		UserServiceImp userServiceImp = new UserServiceImp();
		Scanner scanner = new Scanner(System.in);
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		System.out.println("Enter the User_id : ");
		String user_id = scanner.nextLine();
		System.out.println("Enter the User_Name : ");
		String user_name = scanner.nextLine();
		System.out.println("Enter the Email : ");
		String email = scanner.nextLine();
		System.out.println("Enter the PhoneNo : ");
		Long phoneNo = scanner.nextLong();

		userServiceImp.addUser(new User(user_id, user_name, email, phoneNo));
		System.out.println("New User Added successfully.");

	}

}
