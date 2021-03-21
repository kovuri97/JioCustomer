package com.app.service;

import java.util.List;

import com.app.model.Customer;

public interface CustomerService {
	public void register(Customer customer);
	public List<Customer> getCustomers();
	public Customer getCustomer(int id);
}


