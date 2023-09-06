package com.canddella.entity;

import java.time.LocalDate;

public class Vehicle {
	private String vehicle_Id;
	private String vehicle_Type;
	private String vehicle_brand;
	private String vehicle_Model;
	private String vehicle_year;
	private int vehicle_Capacity;
	private String vehicle_Colour;
	
	
	
	public Vehicle(String vehicle_Id, String vehicle_Type, String vehicle_brand, String vehicle_Model,
			String vehicle_year, int vehicle_Capacity, String vehicle_Colour) {
		super();
		this.vehicle_Id = vehicle_Id;
		this.vehicle_Type = vehicle_Type;
		this.vehicle_brand = vehicle_brand;
		this.vehicle_Model = vehicle_Model;
		this.vehicle_year = vehicle_year;
		this.vehicle_Capacity = vehicle_Capacity;
		this.vehicle_Colour = vehicle_Colour;
	}
	public Vehicle(String string, String string2, String string3, String string4, LocalDate customer_dob, long long1,
			long long2) {
		// TODO Auto-generated constructor stub
	}
	public Vehicle() {
		// TODO Auto-generated constructor stub
	}
	public String getVehicle_Id() {
		return vehicle_Id;
	}
	public void setVehicle_Id(String vehicle_Id) {
		this.vehicle_Id = vehicle_Id;
	}
	public String getVehicle_Type() {
		return vehicle_Type;
	}
	public void setVehicle_Type(String vehicle_Type) {
		this.vehicle_Type = vehicle_Type;
	}
	public String getVehicle_brand() {
		return vehicle_brand;
	}
	public void setVehicle_brand(String vehicle_brand) {
		this.vehicle_brand = vehicle_brand;
	}
	public String getVehicle_Model() {
		return vehicle_Model;
	}
	public void setVehicle_Model(String vehicle_Model) {
		this.vehicle_Model = vehicle_Model;
	}
	public String getVehicle_year() {
		return vehicle_year;
	}
	public void setVehicle_year(String vehicle_year) {
		this.vehicle_year = vehicle_year;
	}
	public int getVehicle_Capacity() {
		return vehicle_Capacity;
	}
	public void setVehicle_Capacity(int vehicle_Capacity) {
		this.vehicle_Capacity = vehicle_Capacity;
	}
	public String getVehicle_Colour() {
		return vehicle_Colour;
	}
	public void setVehicle_Colour(String vehicle_Colour) {
		this.vehicle_Colour = vehicle_Colour;
	}
	
	
	

}
