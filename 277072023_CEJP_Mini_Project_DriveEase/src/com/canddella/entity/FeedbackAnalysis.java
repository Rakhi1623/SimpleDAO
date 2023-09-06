package com.canddella.entity;

public class FeedbackAnalysis {
	private String feedback_Id;
	private String feedback;
	private Customer customer;
	private Drivers driver;
	public FeedbackAnalysis(String feedback_Id, String feedback, Customer customer, Drivers driver) {
		super();
		this.feedback_Id = feedback_Id;
		this.feedback = feedback;
		this.customer = customer;
		this.driver = driver;
	}
	public String getFeedback_Id() {
		return feedback_Id;
	}
	public void setFeedback_Id(String feedback_Id) {
		this.feedback_Id = feedback_Id;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Drivers getDriver() {
		return driver;
	}
	public void setDriver(Drivers driver) {
		this.driver = driver;
	}
	

}
