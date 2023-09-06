package com.canddella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.VehicleType;

public class VehicleTypeDAOImp implements VehicleTypeDAO {

	@Override
	public List<VehicleType> ListAllVehicle() {
		ArrayList<VehicleType> vehicleTypeList = new ArrayList();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try {
		
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection= ds.getConnection();
			
			
			String sqlQuery = "select * from vehicletype";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			
			ResultSet resultSet	= statement.executeQuery();
			
			
			while(resultSet.next())
			{
				
			
			VehicleType vehicleType = new VehicleType(resultSet.getString(1),resultSet.getString(2));
				vehicleTypeList.add(vehicleType);
			}
			connection.close();
		
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		
		}
			
		return vehicleTypeList;
		
	

	}

}
