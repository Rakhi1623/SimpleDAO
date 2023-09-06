package com.canddella.service;

import java.time.LocalDate;
import java.util.List;

import com.canddella.dao.BookingDAOImp;
import com.canddella.entity.Booking;

public class BookingServiceImp implements BookingService {
	BookingDAOImp bookingDAOImp = new BookingDAOImp();

	@Override
	public void addBooking(Booking booking) {
		bookingDAOImp.addBooking(booking);
	}

	@Override
	public void updateBooking(Booking booking) {
		bookingDAOImp.updateBooking(booking);

	}

	@Override
	public List<Booking> ListAllBooking() {
		
		return bookingDAOImp.ListAllBooking();
	}

	@Override
	public Booking searchBooking(String booking_id) {


		return bookingDAOImp.searchBooking(booking_id);
	}

	@Override
	public List<Booking> getAllBookingBasedOnDate(LocalDate date) {
		
		return bookingDAOImp.getAllBookingBasedOnDate(date) ;
	}

	@Override
	public int getNumberOfBookingsForCustomer(String customerId) {
		
		return bookingDAOImp.getNumberOfBookingsForCustomer(customerId);
	}

}
