package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.CustomerProfile;
import com.app.repo.CustomerProfileRepo;

@Service
public class CustomerProfileServiceImpl implements CustomerProfileService{
	@Autowired
	private CustomerProfileRepo customerProfileRepo;

	@Override
	public void addProfile(CustomerProfile customerProfile) {
		// TODO Auto-generated method stub
		customerProfileRepo.save(customerProfile);
	}

	@Override
	public void updateProfile(CustomerProfile customerProfile) {
		// TODO Auto-generated method stub
		customerProfileRepo.save(customerProfile);
	}

	@Override
	public List<CustomerProfile> getCustomerProfiles() {
		// TODO Auto-generated method stub
		return customerProfileRepo.findAll();
	}

	@Override
	public CustomerProfile getCustomerProfile(int id) {
		// TODO Auto-generated method stub
		Optional<CustomerProfile> c=  customerProfileRepo.findById(id);
		if(c.isPresent()) {
			return c.get();
		}
		return null;
	}

}
