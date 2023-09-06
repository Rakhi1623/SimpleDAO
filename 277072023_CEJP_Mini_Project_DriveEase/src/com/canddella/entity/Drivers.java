package com.canddella.entity;

import java.time.LocalDate;

public class Drivers {
	private String driver_Id;
	private String driver_firstName;
	private String driver_lastName;
	private LocalDate driver_dob;
	private String driver_address;
	private long driver_phoneNo;
	private long driver_adharNo;
	public Drivers(String driver_Id, String driver_firstName, String driver_lastName, LocalDate driver_dob,
			String driver_address, long driver_phoneNo, long driver_adharNo) {
		super();
		this.driver_Id = driver_Id;
		this.driver_firstName = driver_firstName;
		this.driver_lastName = driver_lastName;
		this.driver_dob = driver_dob;
		this.driver_address = driver_address;
		this.driver_phoneNo = driver_phoneNo;
		this.driver_adharNo = driver_adharNo;
	}
	public Drivers() {
		// TODO Auto-generated constructor stub
	}
	public String getDriver_Id() {
		return driver_Id;
	}
	public void setDriver_Id(String driver_Id) {
		this.driver_Id = driver_Id;
	}
	public String getDriver_firstName() {
		return driver_firstName;
	}
	public void setDriver_firstName(String driver_firstName) {
		this.driver_firstName = driver_firstName;
	}
	public String getDriver_lastName() {
		return driver_lastName;
	}
	public void setDriver_lastName(String driver_lastName) {
		this.driver_lastName = driver_lastName;
	}
	public LocalDate getDriver_dob() {
		return driver_dob;
	}
	public void setDriver_dob(LocalDate driver_dob) {
		this.driver_dob = driver_dob;
	}
	public String getDriver_address() {
		return driver_address;
	}
	public void setDriver_address(String driver_address) {
		this.driver_address = driver_address;
	}
	public long getDriver_phoneNo() {
		return driver_phoneNo;
	}
	public void setDriver_phoneNo(long driver_phoneNo) {
		this.driver_phoneNo = driver_phoneNo;
	}
	public long getDriver_adharNo() {
		return driver_adharNo;
	}
	public void setDriver_adharNo(long driver_adharNo) {
		this.driver_adharNo = driver_adharNo;
	}
	
}
