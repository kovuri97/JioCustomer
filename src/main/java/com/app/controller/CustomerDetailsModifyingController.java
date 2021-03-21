package com.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.app.model.Customer;
import com.app.model.CustomerProfile;
import com.app.model.CutomerFullDetails;
import com.app.model.CutomerPlanFraming;
import com.app.model.FamilyFriendsDetails;
import com.app.service.CustomerProfileService;
import com.app.service.CustomerService;


@RestController
public class CustomerDetailsModifyingController {

	@Autowired
	private CustomerProfileService customerProfileService;
	@Autowired
	private CustomerService customerService;

	@GetMapping("/getCallDetails/{name}")
	public Object getCallDetails(@PathVariable String name) {

		String baseUrl = "http://localhost:5001/CallDetails/info/"+name;
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<?> response=restTemplate.exchange(baseUrl,HttpMethod.GET,entity,String.class);
		return response.getBody();
	}

	@GetMapping("/getPlans")
	public Object getPlans() {

		String baseUrl = "http://localhost:5000/JioPlans/PlansDetails"; 
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers); 
		RestTemplate restTemplate = new RestTemplate(); ResponseEntity<String>
		response=restTemplate.exchange(baseUrl,HttpMethod.GET,entity,String.class);
		return response.getBody();
	}

	@GetMapping("/getFamilyFriendsDetails/{id}")
	public Object getcallDetails(@PathVariable int id) {

		String baseUrl = "http://localhost:5002/FamilyFriends/getDetails/"+id;
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<?> response=restTemplate.exchange(baseUrl,HttpMethod.GET,entity,String.class);
		return response.getBody();
	}

	@GetMapping("/getActivePlanDetails/{id}")
	public Object getPlanDetails(@PathVariable int id) {

		String baseUrl = "http://localhost:5000/Plans/getCustomerPlanDetails/"+id; 
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<?> response=restTemplate.exchange(baseUrl,HttpMethod.GET,entity,String.class);
		return response.getBody();
	}

	@PostMapping("/rechargePlan")
	public Object rechargePlan(@RequestBody CutomerPlanFraming cutomerPlanFraming) {

		String baseUrl = "http://localhost:5000/Plans/ActivatePlan/";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<CutomerPlanFraming> entity = new HttpEntity<CutomerPlanFraming>(cutomerPlanFraming,headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response=restTemplate.exchange(baseUrl,HttpMethod.POST,entity,String.class);
		return response.getBody();
	}

	@PostMapping("/addFamilyFriendsDetails")
	public Object addFamilyFriendsDetails(@RequestBody FamilyFriendsDetails familyFriendsDetails) {

		String baseUrl = "http://localhost:5002/FamilyFriends/addDetails";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<FamilyFriendsDetails> entity = new HttpEntity<FamilyFriendsDetails>(familyFriendsDetails,headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response=restTemplate.exchange(baseUrl,HttpMethod.POST,entity,String.class);
		return response.getBody();
	}
	@PutMapping("/updateFamilyFriendsDetails")
	public Object updateFamilyFriendsDetails(@RequestBody FamilyFriendsDetails familyFriendsDetails) {

		String baseUrl = "http://localhost:5002/FamilyFriends/updateDetails";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<FamilyFriendsDetails> entity = new HttpEntity<FamilyFriendsDetails>(familyFriendsDetails,headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response=restTemplate.exchange(baseUrl,HttpMethod.PUT,entity,String.class);
		return response.getBody();
	}

	@DeleteMapping("/deleteFamilyFriendsDetails/{name}")
	public Object deleteFamilyFriendsDetails(@PathVariable String name) {

		String baseUrl = "http://localhost:5002/FamilyFriends/deleteDetails/"+name;
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<?> response=restTemplate.exchange(baseUrl,HttpMethod.DELETE,entity,String.class);
		return response.getBody();
	}


	@GetMapping("/getCustomerAllDetails/{id}")
	public ResponseEntity<?> getAllDetails(@PathVariable int id){
		CutomerFullDetails cutomerFullDetails = new CutomerFullDetails();
		List<CustomerProfile> customerProfilesList = customerProfileService.getCustomerProfiles();
		for(CustomerProfile value : customerProfilesList) {
			if(value.getCustomerId() == id) {
				Customer customer = customerService.getCustomer(id);
				cutomerFullDetails.setCustomerId(id);
				cutomerFullDetails.setEmailId(customer.getEmailId());
				cutomerFullDetails.setFullName(customer.getFullName());
			}
			List<CustomerProfile> customerProfile = customerProfileService.getCustomerProfiles();
			for(CustomerProfile value1 : customerProfile) {
				if(value1.getCustomerId() == id) {
					cutomerFullDetails.setDOB(value1.getDOB());
					cutomerFullDetails.setLanguage(value1.getLanguage());
					cutomerFullDetails.setPhonenumber(value1.getPhonenumber());
					cutomerFullDetails.setWaysToContact(value1.getWaysToContact());
					cutomerFullDetails.setWorkDetails(value1.getWorkDetails());
					cutomerFullDetails.setAddress(value1.getAddress());
				}
			}
			String baseUrl = "http://localhost:5000/Plans/getCustomerPlanDetails/"+id; 
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<String>(headers);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<?> response=restTemplate.exchange(baseUrl,HttpMethod.GET,entity,String.class);
			cutomerFullDetails.setCustomerPlanDetails(response.getBody());

			String baseUrl1 = "http://localhost:5002/FamilyFriends/getDetails/"+id;
			HttpEntity<String> entity1 = new HttpEntity<String>(headers);
			RestTemplate restTemplate1 = new RestTemplate();
			ResponseEntity<?> response1=restTemplate1.exchange(baseUrl1,HttpMethod.GET,entity1,String.class);
			cutomerFullDetails.setFamilyFriendsDetails(response1.getBody());
			return ResponseEntity.ok().body(cutomerFullDetails);
		}
		return null;
	}
}
