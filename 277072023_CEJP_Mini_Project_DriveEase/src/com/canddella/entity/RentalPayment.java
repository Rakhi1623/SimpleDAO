package com.canddella.entity;

import java.time.LocalDate;

public class RentalPayment {
	private String rentalPayment_id;
	private Long amount;
	private LocalDate payment_date;
	private String payment_method;
	private Rental rental;
	public RentalPayment(String rentalPayment_id, Long amount, LocalDate payment_date, String payment_method,
			Rental rental) {
		super();
		this.rentalPayment_id = rentalPayment_id;
		this.amount = amount;
		this.payment_date = payment_date;
		this.payment_method = payment_method;
		this.rental = rental;
	}
	public String getRentalPayment_id() {
		return rentalPayment_id;
	}
	public void setRentalPayment_id(String rentalPayment_id) {
		this.rentalPayment_id = rentalPayment_id;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public LocalDate getPayment_date() {
		return payment_date;
	}
	public void setPayment_date(LocalDate payment_date) {
		this.payment_date = payment_date;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	public Rental getRental() {
		return rental;
	}
	public void setRental(Rental rental) {
		this.rental = rental;
	}
	
	
	
}