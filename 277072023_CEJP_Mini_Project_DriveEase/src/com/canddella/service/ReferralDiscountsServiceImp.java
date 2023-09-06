package com.canddella.service;

import java.util.List;

import com.canddella.dao.ReferralDiscountDAOImp;
import com.canddella.entity.Booking;
import com.canddella.entity.Customer;
import com.canddella.entity.ReferralDiscounts;

public class ReferralDiscountsServiceImp implements ReferralDiscountsService {
	
	
	ReferralDiscountDAOImp ReferralDiscountDAOImp =new ReferralDiscountDAOImp();

	@Override
	public ReferralDiscounts searchReferralDiscount(String referralDiscount_id) {
	
		return ReferralDiscountDAOImp.searchReferralDiscount(referralDiscount_id);
	}

	@Override
	public void updateStatus(String customer_id)  {
		ReferralDiscountDAOImp.updateStatus(customer_id);

	}

	@Override
	public void addReferralDiscount(ReferralDiscounts referralDiscount) {
		ReferralDiscountDAOImp.addReferralDiscount(referralDiscount);
	}

	@Override
	public List<ReferralDiscounts> listAllReferralDiscount() {
		return ReferralDiscountDAOImp.listAllReferralDiscount();
	}

	public boolean hasReceivedDiscount(String referringCustomer_id) {
		
		return false;
	}

	@Override
	public void updateReferralDiscounts(ReferralDiscounts referralDiscount) {
		
		ReferralDiscountDAOImp.updateReferralDiscounts(referralDiscount);
	}

	@Override
	public ReferralDiscounts searchReferralDiscount( Customer customer) {
		
		return ReferralDiscountDAOImp.searchReferralDiscount(customer);
	}

	@Override
	public ReferralDiscounts searchReferralDiscount(ReferralDiscounts referralDiscount) {
			return ReferralDiscountDAOImp.searchReferralDiscount(referralDiscount);
	}

}
