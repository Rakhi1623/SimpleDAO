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
import com.canddella.entity.User;

public class UserDAOImp implements UserDAO {

	@Override
	public User searchUser(String user_id) {
				User user =null;
		try {

		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		Connection connection = null;
		DataSource ds = DBConnectionPool.getDataSource();
		connection = ds.getConnection();

		
		String sqlQuery = "select * from user where user_id =?";

		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		statement.setString(1, user_id);
		;

		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {
		   


			 user = new User(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),resultSet.getLong(4));
		   
		}
	} catch (Exception e) {
		System.out.println(e.getMessage());

	}
		return user;





	
	}

	@Override
	public void addUser(User user) {
		Connection connection = null;

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			String sqlQuery = "insert into user (user_id,user_name,email,phoneNo) " + "values(?, ?, ?, ?)";

			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setString(1, user.getUser_id());
			statement.setString(2, user.getUser_Name());
			statement.setString(3, user.getEmail());
			statement.setLong(4, user.getPhoneNo());

			statement.executeUpdate();

			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

	}

	@Override
	public void updateUser(User user) {
		try {

			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			String sqlQuery = "UPDATE user SET user_Name = ?, email = ?,phoneNo = ? WHERE user_id = ?";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			statement.setString(1,user.getUser_Name());
			statement.setString(2, user.getEmail());
			statement.setLong(3,user.getPhoneNo());
			statement.setString(4,user.getUser_id());

			statement.executeUpdate();

			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

	

	@Override
	public List<User> ListAllUser() {
		ArrayList<User> userList = new ArrayList();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try {

			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			String sqlQuery = "select * from user";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
			

				User user = new User(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),resultSet.getLong(4));
				userList.add(user);
			}
			connection.close();
			

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

		return userList;


	}

}
