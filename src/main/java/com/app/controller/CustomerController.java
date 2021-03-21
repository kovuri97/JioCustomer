package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Customer;
import com.app.model.CustomerLogin;
import com.app.model.CustomerProfile;
import com.app.service.CustomerProfileService;
import com.app.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private CustomerProfileService customerProfileService;

	@PostMapping("/register")
	public ResponseEntity<?> customerRegister(@RequestBody Customer customer){
		List<Customer> customerList = customerService.getCustomers();
		CustomerProfile customerProfile = new CustomerProfile();
		for(Customer value : customerList) {
			if(value.getEmailId().equalsIgnoreCase(customer.getEmailId()) || value.getFullName().equalsIgnoreCase(customer.getFullName())) {
				return ResponseEntity.ok().body("Customer with this details already available");
			}
			else {
				customerService.register(customer);
				customerProfileService.addProfile(customerProfile);
				return ResponseEntity.ok().body("Successfully registered");
			}
		}
		customerService.register(customer);
		customerProfileService.addProfile(customerProfile);
		return ResponseEntity.ok().body("Successfully registered");
	}

	@PostMapping("/login")
	public ResponseEntity<?> customerLogin(@RequestBody CustomerLogin customerLogin){
		List<Customer> customerList = customerService.getCustomers();
		for(Customer value : customerList) {
			if(value.getEmailId().equalsIgnoreCase(customerLogin.getEmailId()) && value.getPassword().equalsIgnoreCase(customerLogin.getPassword())) {
				return ResponseEntity.ok().body("Successfully login");
			}
			else {
				return ResponseEntity.ok().body("UnSuccessfully login");
			}
		}
		return ResponseEntity.ok().body("UnSuccessfully login");
	}

	@PutMapping("/updateProfile")
	public ResponseEntity<?> upadteProfile(@RequestBody CustomerProfile customerProfile){
		List<CustomerProfile> customerProfilesList = customerProfileService.getCustomerProfiles();
		for(CustomerProfile value : customerProfilesList) {
			if(value.getCustomerId()==customerProfile.getCustomerId()) {
				customerProfileService.updateProfile(customerProfile);
				return ResponseEntity.ok().body("Successfully updated the profile");
			}
			else {
				return ResponseEntity.ok().body("UnSuccessfully updated the profile, customer not exist");
			}
		}
		return ResponseEntity.ok().body("UnSuccessfully updated the profile, customer not exist");
	}

}
