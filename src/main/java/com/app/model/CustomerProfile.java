package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	private String DOB;
	private long phonenumber;
	private String language;
	private String waysToContact;
	private String workDetails;
	private String address;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
	
}
