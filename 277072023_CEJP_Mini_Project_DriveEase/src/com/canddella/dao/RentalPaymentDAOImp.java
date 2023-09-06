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
import com.canddella.entity.Booking;
import com.canddella.entity.BookingPayment;
import com.canddella.entity.Rental;
import com.canddella.entity.RentalPayment;

public class RentalPaymentDAOImp implements RentalPaymentDAO {

	@Override
	public RentalPayment searchrentalPayment(String rentalPayment_id) {
	
		 RentalPayment rentalPayment = null;
		
		    try {
		        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		        Connection connection = null;
		        DataSource ds = DBConnectionPool.getDataSource();
		        connection = ds.getConnection();

		        String sqlQuery = "SELECT * FROM rentalpayment WHERE rentalpayment_id = ?";

		        PreparedStatement statement = connection.prepareStatement(sqlQuery);
		        statement.setString(1, rentalPayment_id);

		        ResultSet resultSet = statement.executeQuery();

		        while (resultSet.next()) {
		            LocalDate payment_date = LocalDate.parse(resultSet.getString(4), format);

		            Rental rental = new Rental();
		            rental.setRental_id(resultSet.getString(2));
		            rentalPayment = new RentalPayment(resultSet.getString(1), resultSet.getLong(3), payment_date, resultSet.getString(5), rental);
		        }

		       

		    } catch (Exception e) {
		        System.out.println(e.getMessage());
		    }
		    return rentalPayment;
		}

	

	@Override
	public void addRentalPayment(RentalPayment rentalPayment) {

		try {
			DateTimeFormatter formatter=  DateTimeFormatter.ofPattern("yyyy-mm-dd");
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			
			String sqlQuery = "insert into rentalpayment(rentalpayment_id,rental_id,amount,payment_date,payment_method)"+"values(?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setString(1, rentalPayment.getRentalPayment_id());
			statement.setString(2, rentalPayment.getRental().getRental_id());
			statement.setLong(3,rentalPayment.getAmount());
			statement.setDate(4,Date.valueOf(rentalPayment.getPayment_date()));
			statement.setString(5, rentalPayment.getPayment_method());
			
			
			
			statement.executeUpdate();
			
			connection.close();
			
			
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		
		}
		}
		
		
	
		
	

	@Override
	public void updateRentalPayment(RentalPayment rentalPayment) {

		try {
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			String sqlQuery = "UPDATE rentalpayment SET amount = ?,payment_date=?,payment_method=? WHERE rentalPayment_id = ?";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			statement.setLong(1, rentalPayment.getAmount());
			statement.setDate(2,Date.valueOf(rentalPayment.getPayment_date()));
			statement.setString(3, rentalPayment.getPayment_method());
			statement.setString(4, rentalPayment.getRentalPayment_id());

			statement.executeUpdate();

			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}
			
		
	

	@Override
	public List<RentalPayment> ListAllRentalPayment() {
		ArrayList<RentalPayment> rentalPaymentList = new ArrayList();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try {
		
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection= ds.getConnection();
			
			
			String sqlQuery = "select * from rentalpayment";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			
			ResultSet resultSet	= statement.executeQuery();
			
			
			while(resultSet.next())
			{
				
			LocalDate payment_date = LocalDate.parse(resultSet.getString(4),format);
			
			Rental rental = new Rental();
			rental.setRental_id(resultSet.getString(2));
			RentalPayment rentalPayment = new RentalPayment(resultSet.getString(1),resultSet.getLong(3),payment_date,resultSet.getString(5),rental);
			rentalPaymentList.add(rentalPayment);
			}
			connection.close();
		
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		
		}
			
		return rentalPaymentList;
	}


	}
	
	


