package com.canddella.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.canddella.entity.Customer;

public class CustomerDAOImpl implements CustomerDAO{

	
	
	@Override
	public Customer searchCustomer(String customerCode) {
		Customer customer=null;
		// TODO Auto-generated method stub
		try {
			String connectionString = "jdbc:mysql://localhost:3306/CEJP_DAO";
			String userName = "root";
			String passWord = "root";
			Connection connection = DriverManager.getConnection(connectionString, userName, passWord);
			
			String sqlQuery = "select * from customer where customerCode =?";
			
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setString(1, customerCode);;
			
			ResultSet resultSet	= statement.executeQuery();
			
			while(resultSet.next())
				customer = new Customer(resultSet.getString(1),resultSet.getString(2));
				connection.close();
		
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			}
			
		return customer;
	}

}
