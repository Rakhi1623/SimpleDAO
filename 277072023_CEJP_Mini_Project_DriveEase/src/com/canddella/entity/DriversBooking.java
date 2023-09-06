package com.canddella.entity;

import java.time.LocalDate;

public class DriversBooking {
	private String driversBooking_id;
	private LocalDate actual_date;
	private Booking booking;
	private Drivers driver;
	public DriversBooking(String driversBooking_id, LocalDate actual_date, Booking booking, Drivers driver) {
		super();
		this.driversBooking_id = driversBooking_id;
		this.actual_date = actual_date;
		this.booking = booking;
		this.driver = driver;
	}
	public DriversBooking() {
		// TODO Auto-generated constructor stub
	}
	public DriversBooking(String driversBooking_id2, LocalDate nActual_date, String booking_id, Drivers driver2) {
		// TODO Auto-generated constructor stub
	}
	public String getDriversBooking_id() {
		return driversBooking_id;
	}
	public void setDriversBooking_id(String driversBooking_id) {
		this.driversBooking_id = driversBooking_id;
	}
	public LocalDate getActual_date() {
		return actual_date;
	}
	public void setActual_date(LocalDate actual_date) {
		this.actual_date = actual_date;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	public Drivers getDriver() {
		return driver;
	}
	public void setDriver(Drivers driver) {
		this.driver = driver;
	}

}
