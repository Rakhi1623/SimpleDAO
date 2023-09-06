package com.canddella.entity;

public class User {
	private String user_id;
	private String user_Name;
	private String email;
	private Long phoneNo;
	public User(String user_id, String user_Name, String email, Long phoneNo) {
		super();
		this.user_id = user_id;
		this.user_Name = user_Name;
		this.email = email;
		this.phoneNo = phoneNo;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_Name() {
		return user_Name;
	}
	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

}
