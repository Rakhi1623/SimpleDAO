package com.canddella.service;

import java.util.List;

import com.canddella.dao.BookingPaymentDAOImp;
import com.canddella.entity.BookingPayment;

public class BookingPaymentServiceImp implements BookingPaymentService {
	BookingPaymentDAOImp paymentDAOImp = new BookingPaymentDAOImp();
	
	@Override
	public BookingPayment searchPayment(String payment_id) {
	
		return paymentDAOImp.searchPayment(payment_id);
	}

	@Override
	public void addPayment(BookingPayment payment) {
		paymentDAOImp.addPayment(payment);
		
	}

	@Override
	public void updatePayment(BookingPayment payment) {
		paymentDAOImp.updatePayment(payment);
		
	}

	@Override
	public List<BookingPayment> ListAllPayment() {
	
		return paymentDAOImp.ListAllPayment();
	}

	
}
