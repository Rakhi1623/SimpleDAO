package com.canddella.dao;

import java.time.LocalDate;
import java.util.List;

import com.canddella.entity.Booking;


public interface BookingDAO {
	
	Booking searchBooking(String booking_id);
	public void addBooking(Booking booking);
	public void updateBooking(Booking booking);
	public List<Booking>ListAllBooking();
	public List<Booking>getAllBookingBasedOnDate(LocalDate date);
	public int getNumberOfBookingsForCustomer(String customerId) ;

}
