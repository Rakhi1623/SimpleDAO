package com.canddella.entity;

public class Rental {
	private String rental_id;
	private int cost_per_hour;
	private Vehicle vehicle;

	
	





	public Rental(String rental_id, int cost_per_hour, Vehicle vehicle) {
		super();
		this.rental_id = rental_id;
		this.cost_per_hour = cost_per_hour;
		this.vehicle = vehicle;
	}

	public Rental() {
		// TODO Auto-generated constructor stub
	}

	public String getRental_id() {
		return rental_id;
	}

	public void setRental_id(String rental_id) {
		this.rental_id = rental_id;
	}

	public int getCost_per_hour() {
		return cost_per_hour;
	}

	public void setCost_per_hour(int cost_per_hour) {
		this.cost_per_hour = cost_per_hour;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	

}
