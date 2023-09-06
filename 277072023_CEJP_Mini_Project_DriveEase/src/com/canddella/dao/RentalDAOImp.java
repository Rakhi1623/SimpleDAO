package com.canddella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Rental;
import com.canddella.entity.Vehicle;

public class RentalDAOImp implements RentalDAO {
	

	@Override
	public void updateRental(Rental rental) {
		
		try {

			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			String sqlQuery = "UPDATE rental SET cost_per_hour = ? WHERE rental_id = ?";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			statement.setInt(1, rental.getCost_per_hour());
			statement.setString(2, rental.getRental_id());

			statement.executeUpdate();

			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

	@Override
	public void addRental(Rental rental) {
		
		try {
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			String sqlQuery = "insert into rental (rental_id,vehicle_id,cost_per_hour) " + "values(?, ?, ?)";

			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setString(1, rental.getRental_id());
			statement.setString(2, rental.getVehicle().getVehicle_Id());
			statement.setInt(3, rental.getCost_per_hour());

			int result = statement.executeUpdate();

			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

	@Override
	public List<Rental> listAllRental() {
		List<Rental> rentalList = new ArrayList<>();

		try {

			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			String sqlQuery = "select * from rental";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				
				Vehicle vehicle = new Vehicle();
				vehicle.setVehicle_Id(resultSet.getString(2));
			    Rental rental = new Rental(resultSet.getString(1), resultSet.getInt(3), vehicle);
				rentalList.add(rental);
			}
			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

		return rentalList;

	}

	@Override
	public Rental searchRental(String  rental_id) {
		Rental rental=null;
		try {
			
			
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			
			String sqlQuery = "select * from rental where rental_id =?";

			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setString(1, rental_id);
			

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				
				Vehicle vehicle = new Vehicle();
				vehicle.setVehicle_Id(resultSet.getString(2));
				rental = new Rental(resultSet.getString(1), resultSet.getInt(3), vehicle);
			
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		

			return rental;
	}
	}

