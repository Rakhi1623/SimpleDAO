package com.canddella.entity;

import java.time.LocalDate;

public class Customer {
	private String customer_id;
	private String customer_firstName;
	private String customer_lastName;
	private String customer_gender;
	private LocalDate customer_dob;
	private long customer_phoneNo;
	private long customer_adharNo;
	
	
	
	public String getCustomer_id() {
		return customer_id;
	}



	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}



	public String getCustomer_firstName() {
		return customer_firstName;
	}



	public void setCustomer_firstName(String customer_firstName) {
		this.customer_firstName = customer_firstName;
	}



	public String getCustomer_lastName() {
		return customer_lastName;
	}



	public void setCustomer_lastName(String customer_lastName) {
		this.customer_lastName = customer_lastName;
	}



	public String getCustomer_gender() {
		return customer_gender;
	}



	public void setCustomer_gender(String customer_gender) {
		this.customer_gender = customer_gender;
	}



	public LocalDate getCustomer_dob() {
		return customer_dob;
	}



	public void setCustomer_dob(LocalDate customer_dob) {
		this.customer_dob = customer_dob;
	}



	public long getCustomer_phoneNo() {
		return customer_phoneNo;
	}



	public void setCustomer_phoneNo(long customer_phoneNo) {
		this.customer_phoneNo = customer_phoneNo;
	}



	public long getCustomer_adharNo() {
		return customer_adharNo;
	}



	public void setCustomer_adharNo(long customer_adharNo) {
		this.customer_adharNo = customer_adharNo;
	}



	public Customer(String customer_id, String customer_firstName, String customer_lastName, String customer_gender,
			LocalDate customer_dob, long customer_phoneNo, long customer_adharNo) {
		super();
		this.customer_id = customer_id;
		this.customer_firstName = customer_firstName;
		this.customer_lastName = customer_lastName;
		this.customer_gender = customer_gender;
		this.customer_dob = customer_dob;
		this.customer_phoneNo = customer_phoneNo;
		this.customer_adharNo = customer_adharNo;
	}



	public Customer(String string, String string2, String string3, String string4, LocalDate customer_dob2,
			String string5, String string6) {
		// TODO Auto-generated constructor stub
	}



	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}