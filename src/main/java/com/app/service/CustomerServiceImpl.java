package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Customer;
import com.app.repo.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public void register(Customer customer) {
		// TODO Auto-generated method stub
		customerRepo.save(customer);
	}

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerRepo.findAll();
	}

	@Override
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		Optional<Customer> c =  customerRepo.findById(id);
		if(c.isPresent()) {
			return c.get();
		}
		return null;
	}

}
