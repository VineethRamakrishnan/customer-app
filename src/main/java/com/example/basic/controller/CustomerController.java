package com.example.basic.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.data.Customer;
import com.example.basic.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

	
	private CustomerService customerutil;
	
	
	public CustomerController(CustomerService customerutil) {
		super();
		this.customerutil = customerutil;
	}

	@PostMapping(value = "/create")
	public Customer createCustomer(@RequestBody Customer customer) {

		return customerutil.saveCustomer(customer);
	}

	@GetMapping(value = "/getAll")
	public List<Customer> getAllCustomers() {

		return customerutil.getAllCustomers();
	}

	@GetMapping(value = "/get/{id}")
	public Customer getCustomerById(@PathVariable(value = "id") Long customerId) {

		return customerutil.getCustomerById(customerId);
	}

	@GetMapping(value = "/getByAddressAndAge/{address}/{age}")
	public List<Customer> getCustomersByAddressAndAge(@PathVariable(value = "address") String address,@PathVariable(value = "age") Long age) {

		return customerutil.getCustomersByAddressAndAge(address, age);
	}
	
	@GetMapping(value = "/getAllByStoredProcedure")
	public List<Customer> getAllCustomersByStoredProcedure() {
		
		return customerutil.getAllCustomersByStoredProcedure();
	}
	
	@GetMapping(value = "/getAllByCustomQuery")
	public List<Customer> getAllCustomersByCustomQuery() {
		
		return customerutil.getAllCustomersByCustomQuery();
	}
	
	@PutMapping(value = "/updatePointsByStoredProcedure/{id}/{points}")
	public Customer updatePointsByStoredProcedure(@PathVariable(value = "id") Long customerId,@PathVariable(value = "points") Double newPoints) {
		
		return customerutil.updateCustomersByStoredProcedure(customerId,newPoints);
	}

}
