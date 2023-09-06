package com.canddella.entity;

public class ReferralDiscounts {
	private String referralDiscount_id;
	private boolean status;
	private Booking booking;
	private Customer customer;
	public ReferralDiscounts(String referralDiscount_id, boolean status, Booking booking, Customer customer) {
		super();
		this.referralDiscount_id = referralDiscount_id;
		this.status = status;
		this.booking = booking;
		this.customer = customer;
	}
	public ReferralDiscounts() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String getReferralDiscount_id() {
		return referralDiscount_id;
	}
	public void setReferralDiscount_id(String referralDiscount_id) {
		this.referralDiscount_id = referralDiscount_id;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public boolean isReferralSuccessful() {
		return status;
	}
	
	
}
