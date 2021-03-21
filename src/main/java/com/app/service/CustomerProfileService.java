package com.app.service;

import java.util.List;

import com.app.model.CustomerProfile;

public interface CustomerProfileService {
	public void addProfile(CustomerProfile customerProfile);
	public void updateProfile(CustomerProfile customerProfile);
	public List<CustomerProfile> getCustomerProfiles();
	public CustomerProfile getCustomerProfile(int id);
}
