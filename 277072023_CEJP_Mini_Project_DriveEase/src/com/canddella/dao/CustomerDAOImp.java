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
import com.canddella.entity.Customer;;

public class CustomerDAOImp implements CustomerDAO {

	

	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub

		try {

			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			String sqlQuery = "insert into customer (customer_id,customer_firstname,customer_lastname,customer_gender,customer_dob,customer_phoneNo,customer_adharNo) "
					+ "values(?, ?, ?, ?, ?,?,?)";

			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setString(1, customer.getCustomer_id());
			statement.setString(2, customer.getCustomer_firstName());
			statement.setString(3, customer.getCustomer_lastName());
			statement.setString(4, customer.getCustomer_gender());
			statement.setDate(5, Date.valueOf(customer.getCustomer_dob()));
			statement.setLong(6, customer.getCustomer_phoneNo());
			statement.setLong(7, customer.getCustomer_adharNo());

			statement.executeUpdate();

			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

	@Override
	public List<Customer> listAllCustomer() {

		ArrayList<Customer> customerList = new ArrayList();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try {

			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			String sqlQuery = "select * from customer";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				LocalDate customer_dob = LocalDate.parse(resultSet.getString(5), format);

				Customer customer = new Customer(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), customer_dob, resultSet.getLong(6), resultSet.getLong(7));
				customerList.add(customer);
			}
			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

		return customerList;

	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub

		try {

			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			String sqlQuery = "UPDATE customer SET customer_firstName = ?, customer_lastName = ?,customer_gender = ?,customer_dob = ?,customer_phoneNo = ?,customer_adharNo = ? WHERE customer_id = ?";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			statement.setString(1, customer.getCustomer_firstName());
			statement.setString(2, customer.getCustomer_lastName());
			statement.setString(3, customer.getCustomer_gender());
			statement.setDate(4, Date.valueOf(customer.getCustomer_dob()));
			statement.setLong(5, customer.getCustomer_phoneNo());
			statement.setLong(6, customer.getCustomer_adharNo());
			statement.setString(7, customer.getCustomer_id());

			statement.executeUpdate();

			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

	@Override
	public Customer searchCustomer(String customer_id) {
		Customer customer=null;
		try {

		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		Connection connection = null;
		DataSource ds = DBConnectionPool.getDataSource();
		connection = ds.getConnection();

		
		String sqlQuery = "select * from customer where customer_id =?";

		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		statement.setString(1, customer_id);
		;

		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {
		    LocalDate customer_dob = LocalDate.parse(resultSet.getString(5), format);

		    customer = new Customer(
		        resultSet.getString(1),
		        resultSet.getString(2),
		        resultSet.getString(3),
		        resultSet.getString(4),
		        customer_dob,
		        resultSet.getLong(6),
		        resultSet.getLong(7)
		    );
		}
	} catch (Exception e) {
		System.out.println(e.getMessage());

	}
		return customer;

}

}
