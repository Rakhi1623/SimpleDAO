package com.canddella.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class BookingPayment {
	private String payment_id;
	private LocalDateTime timeOut;
	private LocalDateTime timeIn;
	private Long amount;
	private LocalDate payment_date;
	private String payment_method;
	private Booking booking;
	public BookingPayment(String payment_id, LocalDateTime timeOut, LocalDateTime timeIn, Long amount,
			LocalDate payment_date, String payment_method, Booking booking) {
		super();
		this.payment_id = payment_id;
		this.timeOut = timeOut;
		this.timeIn = timeIn;
		this.amount = amount;
		this.payment_date = payment_date;
		this.payment_method = payment_method;
		this.booking = booking;
	}
	public String getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
	}
	public LocalDateTime getTimeOut() {
		return timeOut;
	}
	public void setTimeOut(LocalDateTime timeOut) {
		this.timeOut = timeOut;
	}
	public LocalDateTime getTimeIn() {
		return timeIn;
	}
	public void setTimeIn(LocalDateTime timeIn) {
		this.timeIn = timeIn;
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
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
}