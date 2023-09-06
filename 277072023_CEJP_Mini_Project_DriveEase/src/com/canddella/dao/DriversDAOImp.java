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
import com.canddella.entity.Vehicle;
import com.canddella.entity.VehicleType;

public class DriversDAOImp implements DriversDAO {

 Drivers driver=null;




	@Override
	public Drivers searchDrivers(String driver_Id) {
		try {

			
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			
			String sqlQuery = "select * from drivers where driver_id =?";

			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setString(1, driver_Id);
			;

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
			    LocalDate driver_dob = LocalDate.parse(resultSet.getString(4), format);

				 driver = new Drivers(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), driver_dob, resultSet.getString(5),resultSet.getLong(6), resultSet.getLong(7));

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
			return driver;

	}

	@Override
	public void updateDrivers(Drivers driver) {

		try {

			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			String sqlQuery = "UPDATE drivers SET driver_firstname = ?, driver_last_name = ?,driver_dob = ?,driver_address = ?,driver_phoneno = ?,driver_adharno = ? WHERE driver_id = ?";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			
			statement.setString(1, driver.getDriver_firstName());
			statement.setString(2, driver.getDriver_lastName());
			statement.setDate(3,Date.valueOf( driver.getDriver_dob()));
			statement.setString(4, driver.getDriver_address());
			statement.setLong(5, driver.getDriver_phoneNo());
			statement.setLong(6, driver.getDriver_adharNo());
			statement.setString(7, driver.getDriver_Id());

			statement.executeUpdate();

			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}
		
	

	@Override
	public void addDrivers(Drivers driver) {

		try {

			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			String sqlQuery = "insert into drivers (driver_id,driver_firstname,driver_last_name,driver_dob,driver_address,driver_phoneno,driver_adharno) "
					+ "values(?, ?, ?, ?, ?,?,?)";

			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setString(1, driver.getDriver_Id());
			statement.setString(2, driver.getDriver_firstName());
			statement.setString(3, driver.getDriver_lastName());
			statement.setDate(4,Date.valueOf( driver.getDriver_dob()));
			statement.setString(5, driver.getDriver_address());
			statement.setLong(6, driver.getDriver_phoneNo());
			statement.setLong(7, driver.getDriver_adharNo());

			statement.executeUpdate();

			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

		
	

	@Override
	public List<Drivers> listAllDrivers() {

		ArrayList<Drivers> driverList = new ArrayList();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try {

			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			String sqlQuery = "select * from drivers";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				LocalDate driver_dob = LocalDate.parse(resultSet.getString(4), format);

				Drivers driver = new Drivers(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), driver_dob, resultSet.getString(5),resultSet.getLong(6), resultSet.getLong(7));
				driverList.add(driver);
			}
			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

		return driverList;


	}

	
		 

}
