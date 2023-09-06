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
import com.canddella.entity.Vehicle;
import com.canddella.entity.VehicleType;

public class VehicleDAOImp implements VehicleDAO{

	@Override
	public void addVehicle(Vehicle vehicle) {
		// TODO Auto-generated method stub
		
		try {
			DateTimeFormatter formatter=  DateTimeFormatter.ofPattern("yyyy-mm-dd");
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			
			String sqlQuery = "insert into vehicle(vehicle_Id,vehicle_Type,vehicle_brand,vehicle_Model,vehicle_year,vehicle_Capacity,vehicle_Colour)"+"values(?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setString(1, vehicle.getVehicle_Id());
			statement.setString(2, vehicle.getVehicle_Type());
			statement.setString(3, vehicle.getVehicle_brand());
			statement.setString(4, vehicle.getVehicle_Model());
			statement.setString(5, vehicle.getVehicle_year());
			statement.setInt(6, vehicle.getVehicle_Capacity());
			statement.setString(7, vehicle.getVehicle_Colour());
			
			
			statement.executeUpdate();
			
			connection.close();
			
			
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		
		}
		}
		
		
	

	@Override
	public void updateVehicle(Vehicle vehicle) {
		// TODO Auto-generated method stub
		try {
			
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			

			String sqlQuery = "UPDATE vehicle SET vehicle_Type = ?, vehicle_brand = ?, vehicle_model = ?, vehicle_year = ?, vehicle_capacity = ?, vehicle_colour = ? WHERE vehicle_Id = ?";
					
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setString(1, vehicle.getVehicle_Type());
			statement.setString(2, vehicle.getVehicle_brand());
			statement.setString(3,vehicle.getVehicle_Model());
			statement.setString(4, vehicle.getVehicle_year());
			statement.setInt(5, vehicle.getVehicle_Capacity());;
			statement.setString(6,vehicle.getVehicle_Colour() );
			statement.setString(7,vehicle.getVehicle_Id() );
			
			

			statement.executeUpdate();
			
			
		
			connection.close();
		
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		
		}
		}
		
	


		
	

	@Override
	public List<Vehicle> ListAllVehicle() {
		// TODO Auto-generated method stub
		
		ArrayList<Vehicle> vehicleList = new ArrayList();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try {
		
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection= ds.getConnection();
			
			
			String sqlQuery = "select * from vehicle";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			
			ResultSet resultSet	= statement.executeQuery();
			
			
			while(resultSet.next())
			{
				
			
			Vehicle vehicle = new Vehicle(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getInt(6),resultSet.getString(7));
				vehicleList.add(vehicle);
			}
			connection.close();
		
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		
		}
			
		return vehicleList;
		
	
		
		
	

		
	}




	@Override
	public Vehicle searchVehicle(String vehicle_id) {
		Vehicle vehicle=null;
		try {

			
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			
			String sqlQuery = "select * from vehicle where vehicle_id =?";

			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setString(1, vehicle_id);
			;

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
			 

			    
			     vehicle = new Vehicle(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getInt(6),resultSet.getString(7));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
			return vehicle;

	}




	@Override
	public List<Vehicle> getAllVehicleBaseOnType(VehicleType vehicleType) {
		// TODO Auto-generated method stub
		return null;
	}
}
