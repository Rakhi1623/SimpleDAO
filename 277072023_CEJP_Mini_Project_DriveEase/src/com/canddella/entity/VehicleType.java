package com.canddella.entity;

public class VehicleType {
	private String vehicleType_id;
	private String description ;
	public VehicleType(String vehicleType_id, String description) {
		super();
		this.vehicleType_id = vehicleType_id;
		this.description = description;
	}
	public VehicleType() {
		// TODO Auto-generated constructor stub
	}
	public String getVehicleType_id() {
		return vehicleType_id;
	}
	public void setVehicleType_id(String vehicleType_id) {
		this.vehicleType_id = vehicleType_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
