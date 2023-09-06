package com.canddella.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Booking;
import com.canddella.entity.Customer;
import com.canddella.entity.Vehicle;
import com.canddella.entity.VehicleType;

public class BookingDAOImp implements BookingDAO {

	@Override
	public void addBooking(Booking booking) {

		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			String sqlQuery = "insert into booking(booking_id,customer_id,vehicletype_id,vehicle_id,booking_date,actual_date)"
					+ "values(?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setString(1, booking.getBooking_id());
			statement.setString(2, booking.getCustomer().getCustomer_id());
			statement.setString(3, booking.getVehicleType().getVehicleType_id());
			statement.setString(4, booking.getVehicle().getVehicle_Id());
			
			statement.setDate(5, Date.valueOf(booking.getBooking_date()));
			statement.setDate(6, Date.valueOf(booking.getAcutal_date()));

			statement.executeUpdate();

			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

	@Override
	public void updateBooking(Booking booking) {

		try {
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			String sqlQuery = "UPDATE booking SET booking_date=?,actual_date=? WHERE booking_id = ?";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			statement.setDate(1, Date.valueOf(booking.getBooking_date()));
			statement.setDate(2, Date.valueOf(booking.getAcutal_date()));
			statement.setString(3, booking.getBooking_id());

			statement.executeUpdate();

			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

	@Override
	public List<Booking> ListAllBooking() {
		ArrayList<Booking> bookingList = new ArrayList();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try {

			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			String sqlQuery = "select * from booking";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				LocalDate booking_date = LocalDate.parse(resultSet.getString(5), format);
				LocalDate actual_date = LocalDate.parse(resultSet.getString(6), format);

				Customer customer = new Customer();
				customer.setCustomer_id(resultSet.getString(2));
				VehicleType vehicleType = new VehicleType();
				vehicleType.setVehicleType_id(resultSet.getString(3));
				Vehicle vehicle = new Vehicle();
				vehicle.setVehicle_Id(resultSet.getString(4));
				

				Booking booking = new Booking(resultSet.getString(1),booking_date, actual_date, customer,vehicle, vehicleType);
				bookingList.add(booking);
			}
			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

		return bookingList;

	}

	@Override
	public Booking searchBooking(String booking_id) {
	    Booking booking = null;
	    try {
	        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        Connection connection = null;
	        DataSource ds = DBConnectionPool.getDataSource();
	        connection = ds.getConnection();

	        String sqlQuery = "select * from booking where booking_id =?";

	        PreparedStatement statement = connection.prepareStatement(sqlQuery);
	        statement.setString(1, booking_id);

	        ResultSet resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            LocalDate booking_date = LocalDate.parse(resultSet.getString(5), format);
	            LocalDate actual_date = LocalDate.parse(resultSet.getString(6), format);

	            Customer customer = new Customer();
	            customer.setCustomer_id(resultSet.getString(2));
	            VehicleType vehicleType = new VehicleType();
	            vehicleType.setVehicleType_id(resultSet.getString(3));
	            Vehicle vehicle = new Vehicle();
	            vehicle.setVehicle_Id(resultSet.getString(4));

	            Booking booking1 = new Booking(resultSet.getString(1), booking_date, actual_date, customer, vehicle, vehicleType);
	            booking = booking1; // Assign the booking1 object to the booking variable
	        }
	        connection.close();

	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	    return booking; // Return the booking object outside the try-catch block
	}




	@Override
	public List<Booking> getAllBookingBasedOnDate(LocalDate date) {
		
	        List<Booking> bookingList = new ArrayList<>();
	        try {

	    		
	    		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    		Connection connection = null;
	    		DataSource ds = DBConnectionPool.getDataSource();
	    		connection = ds.getConnection();

	       
	        

	            String sqlQuery = "SELECT * FROM booking WHERE actual_date = ?";

	            PreparedStatement statement = connection.prepareStatement(sqlQuery);
	            statement.setString(1, date.format(format));

	            ResultSet resultSet = statement.executeQuery();
	           
	            while (resultSet.next()) {
	                LocalDate booking_date = LocalDate.parse(resultSet.getString("booking_date"), format);
	                LocalDate actual_date = LocalDate.parse(resultSet.getString("actual_date"), format);

	                Customer customer = new Customer();
	                customer.setCustomer_id(resultSet.getString("customer_id"));

	                VehicleType vehicleType = new VehicleType();
	                vehicleType.setVehicleType_id(resultSet.getString("vehicletype_id"));

	                Vehicle vehicle = new Vehicle();
	                vehicle.setVehicle_Id(resultSet.getString("vehicle_id"));
	                String booking_id = (resultSet.getString("booking_id"));

	                Booking booking = new Booking(booking_id, booking_date, actual_date, customer, vehicle, vehicleType);
	                bookingList.add(booking);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return bookingList;
	    }

	@Override
	public int getNumberOfBookingsForCustomer(String customerId) {
		
		    int numberOfBookings = 0; 

		  
		    try {
		        

	    		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    		Connection connection = null;
	    		DataSource ds = DBConnectionPool.getDataSource();
	    		connection = ds.getConnection();

		        
		        String query = "SELECT COUNT(*) FROM booking WHERE customer_id = ?";
		        PreparedStatement preparedStatement = connection.prepareStatement(query);
		        preparedStatement.setString(1, customerId);
		        
		        ResultSet resultSet = preparedStatement.executeQuery();
		        if (resultSet.next()) {
		            numberOfBookings = resultSet.getInt(1);
		        }
		        
		      
		        resultSet.close();
		        preparedStatement.close();
		        connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		       
		    }
		    
		    return numberOfBookings;
	}
	}
	
