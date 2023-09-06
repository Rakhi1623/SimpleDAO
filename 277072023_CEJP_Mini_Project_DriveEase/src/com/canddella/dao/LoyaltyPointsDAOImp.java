package com.canddella.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Customer;
import com.canddella.entity.LoyaltyPoints;

public class LoyaltyPointsDAOImp implements LoyaltyPointsDAO {

	

	@Override
	public int searchLoyaltyPoints(Customer customer) {
	 int loyaltyPoint = 0;
		
		    try {
		        
		        Connection connection = null;
		        DataSource ds = DBConnectionPool.getDataSource();
		        connection = ds.getConnection();

		        String sqlQuery = "SELECT loyaltypoint FROM loyaltypoints WHERE customer_id= ?";

		        PreparedStatement statement = connection.prepareStatement(sqlQuery);
		        statement.setString(1, customer.getCustomer_id());

		        ResultSet resultSet = statement.executeQuery();

		        if (resultSet.next()) {
		            
		            loyaltyPoint=resultSet.getInt(1);
		        }

		       

		    } catch (Exception e) {
		        System.out.println(e.getMessage());
		    }
		    return loyaltyPoint;
		}

	


	@Override
	public void updateLoyaltyPoints(String customer_id) {
		try {
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			String sqlQuery = "UPDATE loyaltypoints SET loyaltypoint = loyaltypoint+1  WHERE customer_id = ?";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			statement.setString(1, customer_id);
			
			statement.executeUpdate();

			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}
			
		
	

	@Override
	public void addLoyaltyPoints(String customer_id) {
		try {
			DateTimeFormatter formatter=  DateTimeFormatter.ofPattern("yyyy-mm-dd");
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			
			String sqlQuery = "insert into loyaltypoints(customer_id,loyaltypoint)"+"values(?,?)";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			
			statement.setString(1,customer_id);
			statement.setLong(2,1);
			
			
			
			
			statement.executeUpdate();
			
			connection.close();
			
			
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		
		}
		}
		
		
	
		
	
	

	@Override
	public List<LoyaltyPoints> listAllLoyaltyPoint() {
		ArrayList<LoyaltyPoints> loyaltyPointList = new ArrayList();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try {
		
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection= ds.getConnection();
			
			
			String sqlQuery = "select * from loyaltypoints";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			
			ResultSet resultSet	= statement.executeQuery();
			
			
				
			

		        while (resultSet.next()) {
		            

		            Customer customer = new Customer();
		            customer.setCustomer_id(resultSet.getString(2));
		            LoyaltyPoints  loyaltyPoints = new LoyaltyPoints (resultSet.getString(1),resultSet.getInt(3),customer);
		            loyaltyPointList.add(loyaltyPoints);
		        }

		       

		    } catch (Exception e) {
		        System.out.println(e.getMessage());
		    }
			
		return loyaltyPointList;
	


	}




	public boolean doesCustomerExist(String customer_id) {
	    boolean exists = false;
	    try {
	        Connection connection = null;
	        DataSource ds = DBConnectionPool.getDataSource();
	        connection = ds.getConnection();

	        String sqlQuery = "SELECT COUNT(*) FROM loyaltypoints WHERE customer_id = ?";
	        PreparedStatement statement = connection.prepareStatement(sqlQuery);

	        statement.setString(1, customer_id);

	        ResultSet resultSet = statement.executeQuery();
	        if (resultSet.next()) {
	            int count = resultSet.getInt(1);
	            exists = count > 0;
	        }

	        connection.close();
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	    return exists;
	}
}








