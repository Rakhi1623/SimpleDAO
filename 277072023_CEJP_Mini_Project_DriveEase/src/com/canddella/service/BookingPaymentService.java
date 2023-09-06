package com.canddella.service;

import java.util.List;

import com.canddella.entity.BookingPayment;

public interface BookingPaymentService {
	BookingPayment searchPayment(String payment_id);
	public void addPayment(BookingPayment payment);
	public void updatePayment(BookingPayment payment);
	public List<BookingPayment>ListAllPayment();


}
