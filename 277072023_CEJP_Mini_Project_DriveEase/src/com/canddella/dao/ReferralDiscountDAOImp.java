package com.canddella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Booking;
import com.canddella.entity.Customer;
import com.canddella.entity.ReferralDiscounts;
import com.canddella.entity.Rental;
import com.canddella.entity.Vehicle;

public class ReferralDiscountDAOImp implements ReferralDiscountDAO {

	@Override
	public ReferralDiscounts searchReferralDiscount(String referralDiscount_id) {
		ReferralDiscounts referralDiscount =null;
		try {
			
			
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			
			String sqlQuery = "select * from referraldiscounts where referraldiscount_id =?";

			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setString(1, referralDiscount_id);
			

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Booking booking = new Booking();
				booking.setBooking_id(resultSet.getString(2));
				Customer customer = new Customer();
				customer.setCustomer_id(resultSet.getString(3));
				
				ReferralDiscounts referralDiscount1 = new ReferralDiscounts(resultSet.getString(1),resultSet.getBoolean(4),booking, customer);
			
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		

			return referralDiscount;
	
	}

	@Override
	public void updateStatus(String customer_id) {
		try {

			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			String sqlQuery = "UPDATE referraldiscounts SET status = ? WHERE customer_id = ?";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			statement.setBoolean(1, false);
			statement.setString(2, customer_id);

			statement.executeUpdate();

			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}
	

	@Override
	public void addReferralDiscount(ReferralDiscounts referralDiscount) {
		try {
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			String sqlQuery = "insert into referraldiscounts (referraldiscount_id,booking_id,customer_id,status) " + "values(?, ?, ?,?)";

			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setString(1, referralDiscount.getReferralDiscount_id());
			statement.setString(2, referralDiscount.getBooking().getBooking_id());
			statement.setString(3, referralDiscount.getCustomer().getCustomer_id());
			statement.setBoolean(4, referralDiscount.isStatus());

			int result = statement.executeUpdate();

			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}
	

	@Override
	public List<ReferralDiscounts> listAllReferralDiscount() {
		List<ReferralDiscounts> referralDiscountsList = new ArrayList<>();

		try {

			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			String sqlQuery = "select * from referraldiscounts";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				
			Booking booking = new Booking();
			booking.setBooking_id(resultSet.getString(2));
			Customer customer = new Customer();
			customer.setCustomer_id(resultSet.getString(3));
			
			ReferralDiscounts referralDiscount = new ReferralDiscounts(resultSet.getString(1),resultSet.getBoolean(4),booking, customer);
			referralDiscountsList.add(referralDiscount);
			}
			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

		return referralDiscountsList;

	
	}

	@Override
	public void updateReferralDiscounts(ReferralDiscounts referralDiscount) {
		try {
			
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			

			String sqlQuery = "UPDATE referraldiscounts SET status = ? WHERE referraldiscount_id = ?";
					
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setBoolean(1,referralDiscount.isStatus() );
			statement.setString(2, referralDiscount.getReferralDiscount_id());
			
			

			statement.executeUpdate();
			
			
		
			connection.close();
		
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		
		}
		}

	@Override
	public ReferralDiscounts searchReferralDiscount( Customer customer) {
		 
		
		    ReferralDiscounts referralDiscount = null;
		    
		    try {
		        Connection connection = null;
		        DataSource ds = DBConnectionPool.getDataSource();
		        connection = ds.getConnection();
		      

		    	String sqlQuery = "select * from referraldiscounts where customer_id =?";

				PreparedStatement statement = connection.prepareStatement(sqlQuery);
				statement.setString(1, customer.getCustomer_id());
				

				ResultSet resultSet = statement.executeQuery();

				while (resultSet.next()) {
					Booking booking = new Booking();
					booking.setBooking_id(resultSet.getString(2));
					Customer customer1 = new Customer();
					customer1.setCustomer_id(resultSet.getString(3));
					
					if(resultSet.getBoolean(4))
						referralDiscount = new ReferralDiscounts(resultSet.getString(1),resultSet.getBoolean(4),booking, customer1);
				}
	

		    } catch (Exception e) {
		        System.out.println(e.getMessage());
		    }
		    
		    return referralDiscount;
		}

	@Override
	public ReferralDiscounts searchReferralDiscount(ReferralDiscounts referralDiscount) {
		
		try {
			
			
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			
			String sqlQuery = "select customer_id from referraldiscounts where referraldiscount_id =?";

			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setString(1, referralDiscount.getReferralDiscount_id());
			

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				
				Customer customer = new Customer();
				customer.setCustomer_id(resultSet.getString(1));
				
				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		

			return referralDiscount;
	
	}

	}

		
	
		
	


