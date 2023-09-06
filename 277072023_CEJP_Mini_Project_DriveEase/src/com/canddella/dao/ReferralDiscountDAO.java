package com.canddella.dao;

import java.util.List;

import com.canddella.entity.Booking;
import com.canddella.entity.Customer;
import com.canddella.entity.ReferralDiscounts;


public interface ReferralDiscountDAO {
	ReferralDiscounts searchReferralDiscount(String referralDiscount_id);
	
	public void updateStatus(String customer_id);
	ReferralDiscounts searchReferralDiscount( Customer customer);
	
	public void updateReferralDiscounts(ReferralDiscounts referralDiscount );
	ReferralDiscounts searchReferralDiscount( ReferralDiscounts referralDiscount);
	
	public void addReferralDiscount(ReferralDiscounts referralDiscount);
	
	public List<ReferralDiscounts> listAllReferralDiscount ();

}
