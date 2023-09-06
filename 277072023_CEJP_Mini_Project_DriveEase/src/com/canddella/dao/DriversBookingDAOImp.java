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
import com.canddella.entity.Drivers;
import com.canddella.entity.DriversBooking;
import com.canddella.entity.Vehicle;
import com.canddella.entity.VehicleType;

public class DriversBookingDAOImp implements DriversBookingDAO {

	;

	@Override
	public DriversBooking searchDriversBooking(String driversBooking_id) {
		DriversBooking driversBooking = null;
		try {

			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			
			String sqlQuery = "select * from driversbooking where driverbooking_id =?";

			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setString(1, driversBooking_id);
			;

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
			    LocalDate nActual_Date = LocalDate.parse(resultSet.getString(4), format);
			    Booking booking = new Booking();
				booking.setBooking_id(resultSet.getString(2));
				Drivers driver = new Drivers();
				driver.setDriver_Id(resultSet.getString(3));
				LocalDate nActualDate = LocalDate.parse(resultSet.getString(4));

				DriversBooking driversBooking1 = new DriversBooking(resultSet.getString(1), nActualDate,booking, driver );
				 
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
			return driversBooking;

	}

	
	@Override
	public void updateDriversBookingr(DriversBooking driversBooking) {

		try {

			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			String sqlQuery = "UPDATE driversbooking SET actual_date=?  WHERE driverbooking_id = ?";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			statement.setDate(1,Date.valueOf( driversBooking.getActual_date()));
			statement.setString(2, driversBooking.getDriversBooking_id());
			
			statement.executeUpdate();

			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

	@Override
	public void addDriversBooking(DriversBooking driversBooking) {

		try {

			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			String sqlQuery = "insert into driversbooking (driverbooking_id,booking_id,driver_id,actual_date) "
					+ "values(?, ?, ?, ?)";

			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setString(1, driversBooking.getDriversBooking_id());
			statement.setString(2, driversBooking.getBooking().getBooking_id());
			statement.setString(3, driversBooking.getDriver().getDriver_Id());
			statement.setDate(4,Date.valueOf( driversBooking.getActual_date()));
			
			statement.executeUpdate();

			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

	@Override
	public List<DriversBooking> listAllDriversBooking() {
		ArrayList<DriversBooking> driversBookingList = new ArrayList();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try {

			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			String sqlQuery = "select * from driversbooking";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				LocalDate actual_date = LocalDate.parse(resultSet.getString(4), format);
				Booking booking = new Booking();
				booking.setBooking_id(resultSet.getString(2));
				Drivers driver = new Drivers();
				driver.setDriver_Id(resultSet.getString(3));
				LocalDate nActualDate = LocalDate.parse(resultSet.getString(4));

				DriversBooking driversBooking = new DriversBooking(resultSet.getString(1), nActualDate,booking, driver );
				driversBookingList.add(driversBooking);
			}
			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

		return driversBookingList;


	}


	@Override
	public List<DriversBooking> getAllDriversBookingBasedOnDate(LocalDate date) {
		 List<DriversBooking> driversBookingList = new ArrayList<>();
	        try {

	    		
	    		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    		Connection connection = null;
	    		DataSource ds = DBConnectionPool.getDataSource();
	    		connection = ds.getConnection();

	       
	        

	            String sqlQuery = "SELECT * FROM driversbooking WHERE actual_date = ?";

	            PreparedStatement statement = connection.prepareStatement(sqlQuery);
	            statement.setString(1, date.format(format));

	            ResultSet resultSet = statement.executeQuery();
	           
	            while (resultSet.next()) {
	                LocalDate actual_date = LocalDate.parse(resultSet.getString("actual_date"), format);

	                Booking booking = new Booking();
	                booking.setBooking_id(resultSet.getString("booking_id")); 
	                Drivers driver = new Drivers();
	                driver.setDriver_Id(resultSet.getString("driver_id")); 
					LocalDate nActualDate = LocalDate.parse(resultSet.getString(4));

					DriversBooking driversBooking = new DriversBooking(resultSet.getString(1), nActualDate,booking, driver );
					driversBookingList.add(driversBooking);
	               
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return driversBookingList;
	    }
	
	

	}
	
