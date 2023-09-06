package com.canddella.service;

import java.util.List;


import com.canddella.entity.Customer;
import com.canddella.entity.ReferralDiscounts;

public interface ReferralDiscountsService {
	ReferralDiscounts searchReferralDiscount(String referralDiscount_id);
	ReferralDiscounts searchReferralDiscount( Customer customer);

	public ReferralDiscounts searchReferralDiscount(ReferralDiscounts referralDiscount);
	public void updateStatus(String customer_id) ;
	
	public void updateReferralDiscounts(ReferralDiscounts referralDiscount);
	
	public void addReferralDiscount(ReferralDiscounts referralDiscount);

	public List<ReferralDiscounts> listAllReferralDiscount();
}
