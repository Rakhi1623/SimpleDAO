package com.canddella.entity;

public class LoyaltyPoints {
	private String loyaltPoints_Id;
	private int loyaltyPoint;
	private Customer customer;
	public LoyaltyPoints(String loyaltPoints_Id, int loyaltyPoint, Customer customer) {
		super();
		this.loyaltPoints_Id = loyaltPoints_Id;
		this.loyaltyPoint = 1;
		this.customer = customer;
	}
	public LoyaltyPoints() {
		// TODO Auto-generated constructor stub
	}
	public LoyaltyPoints(String string, String customer_id) {
		// TODO Auto-generated constructor stub
	}
	public String getLoyaltPoints_Id() {
		return loyaltPoints_Id;
	}
	public void setLoyaltPoints_Id(String loyaltPoints_Id) {
		this.loyaltPoints_Id = loyaltPoints_Id;
	}
	public int getLoyaltyPoint() {
		return loyaltyPoint;
	}
	public void setLoyaltyPoint(int loyaltyPoint) {
		this.loyaltyPoint = loyaltyPoint;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	


}
