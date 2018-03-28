package com.example.basic.service;

import java.util.List;

import com.example.basic.data.Customer;

public interface CustomerService {

	Customer saveCustomer(Customer customer);

	List<Customer> getAllCustomers();

	Customer getCustomerById(Long customerId);
	
	List<Customer> getCustomersByAddressAndAge(String address,Long age);
}
