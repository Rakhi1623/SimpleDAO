package com.canddella.entity;

import java.time.LocalDate;

public class Booking {
	
	private String booking_id;
	private LocalDate booking_date;
	private LocalDate acutal_date;
	private Customer customer;
	private Vehicle vehicle;
	private VehicleType vehicleType;
	public Booking(String booking_id, LocalDate booking_date, LocalDate acutal_date, Customer customer, Vehicle vehicle,
			VehicleType vehicleType) {
		super();
		this.booking_id = booking_id;
		this.booking_date = booking_date;
		this.acutal_date = acutal_date;
		this.customer = customer;
		this.vehicle = vehicle;
		this.vehicleType = vehicleType;
	}
	public Booking() {
		// TODO Auto-generated constructor stub
	}
	public String getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(String booking_id) {
		this.booking_id = booking_id;
	}
	public LocalDate getBooking_date() {
		return booking_date;
	}
	public void setBooking_date(LocalDate booking_date) {
		this.booking_date = booking_date;
	}
	public LocalDate getAcutal_date() {
		return acutal_date;
	}
	public void setAcutal_date(LocalDate acutal_date) {
		this.acutal_date = acutal_date;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
	
	
}