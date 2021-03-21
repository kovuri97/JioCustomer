package com.app.model;

import java.util.List;

public class CutomerFullDetails {
	private int customerId;
	private String emailId;
	private String fullName;
	private String DOB;
	private long phonenumber;
	private String language;
	private String waysToContact;
	private String workDetails;
	private String address;
	private Object customerPlanDetails;
	private Object familyFriendsDetails;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public long getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getWaysToContact() {
		return waysToContact;
	}
	public void setWaysToContact(String waysToContact) {
		this.waysToContact = waysToContact;
	}
	public String getWorkDetails() {
		return workDetails;
	}
	public void setWorkDetails(String workDetails) {
		this.workDetails = workDetails;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Object getCustomerPlanDetails() {
		return customerPlanDetails;
	}
	public void setCustomerPlanDetails(Object customerPlanDetails) {
		this.customerPlanDetails = customerPlanDetails;
	}
	public Object getFamilyFriendsDetails() {
		return familyFriendsDetails;
	}
	public void setFamilyFriendsDetails(Object familyFriendsDetails) {
		this.familyFriendsDetails = familyFriendsDetails;
	}
	
}
