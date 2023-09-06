package com.canddella.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Booking;
import com.canddella.entity.BookingPayment;

public class BookingPaymentDAOImp implements BookingPaymentDAO {

	@Override
	public BookingPayment searchPayment(String payment_id) {
		 BookingPayment payment = null;
		    try {
		        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		        DateTimeFormatter formatt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");		        
		        Connection connection = null;
		        DataSource ds = DBConnectionPool.getDataSource();
		        connection = ds.getConnection();

		        String sqlQuery = "SELECT * FROM bookingpayment WHERE payment_id = ?";

		        PreparedStatement statement = connection.prepareStatement(sqlQuery);
		        statement.setString(1, payment_id);

		        ResultSet resultSet = statement.executeQuery();

		        while (resultSet.next()) {
		            LocalDate payment_date = LocalDate.parse(resultSet.getString(6), format);
		            LocalDateTime timeOut = LocalDateTime.parse(resultSet.getString(3), formatt);
					 LocalDateTime timeIn = LocalDateTime.parse(resultSet.getString(4), formatt);
		            Booking booking = new Booking();
		            booking.setBooking_id(resultSet.getString(2));
		           payment = new BookingPayment(resultSet.getString(1), timeOut,timeIn,resultSet.getLong(5), payment_date, resultSet.getString(7), booking);
		        }
		    } catch (Exception e) {
		        System.out.println(e.getMessage());
		    }
		    return payment;
		}






	

	@Override
	public void addPayment(BookingPayment payment) {

		try {
			DateTimeFormatter formatter=  DateTimeFormatter.ofPattern("yyyy-mm-dd");
			DateTimeFormatter formatt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			
			String sqlQuery = "insert into bookingpayment(payment_id,booking_id,time_out,time_in,amount,payment_date,payment_method)"+"values(?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setString(1, payment.getPayment_id());
			statement.setString(2, payment.getBooking().getBooking_id());
			statement.setTimestamp(3, Timestamp.valueOf(payment.getTimeOut())); 
		     statement.setTimestamp(4, Timestamp.valueOf(payment.getTimeIn()));
			statement.setLong(5,payment.getAmount());
			statement.setDate(6,Date.valueOf(payment.getPayment_date()));
			statement.setString(7, payment.getPayment_method());
			
			
			
			statement.executeUpdate();
			
			connection.close();
			
			
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		
		}
		}
		
		
	

	@Override
	public void updatePayment(BookingPayment payment) {

	try {
		Connection connection = null;
		DataSource ds = DBConnectionPool.getDataSource();
		connection = ds.getConnection();

		String sqlQuery = "UPDATE bookingpayment SET time_out=?,time_in=?, amount = ?,payment_date=?,payment_method=? WHERE payment_id = ?";
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		 statement.setTimestamp(3, Timestamp.valueOf(payment.getTimeOut())); 
	     statement.setTimestamp(4, Timestamp.valueOf(payment.getTimeIn()));
		statement.setLong(3, payment.getAmount());
		statement.setDate(4,Date.valueOf(payment.getPayment_date()));
		statement.setString(5, payment.getPayment_method());
		statement.setString(6, payment.getPayment_id());

		statement.executeUpdate();

		connection.close();

	} catch (Exception e) {
		System.out.println(e.getMessage());

	}
}
		
	

	@Override
	public List<BookingPayment> ListAllPayment() {

		
		ArrayList<BookingPayment> paymentList = new ArrayList();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter formatt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		try {
		
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection= ds.getConnection();
			
			
			String sqlQuery = "select * from bookingpayment";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			
			ResultSet resultSet	= statement.executeQuery();
			
			
			while(resultSet.next())
			{
				
			
			
			   LocalDate payment_date = LocalDate.parse(resultSet.getString(6), format);
			   LocalDateTime timeOut = LocalDateTime.parse(resultSet.getString(3), formatt);
			   LocalDateTime timeIn = LocalDateTime.parse(resultSet.getString(4), formatt);
	            Booking booking = new Booking();
	            booking.setBooking_id(resultSet.getString(2));
			BookingPayment payment = new BookingPayment(resultSet.getString(1),timeOut,timeIn,resultSet.getLong(5),payment_date,resultSet.getString(7),booking);
			paymentList.add(payment);
			}
			connection.close();
		
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		
		}
			
		return paymentList;
	}

}
