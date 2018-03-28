package com.example.basic.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.basic.data.Customer;
import com.example.basic.repository.CustomerRepository;

@Service
public class CustomerServiceUtility implements CustomerService {

	@Autowired
	private CustomerRepository customerrepo;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceUtility.class);
	
	@Override
	public Customer saveCustomer(Customer customer) {
		
		if(customer.equals(null))
		{
			LOGGER.info("NULL OBJECT");
			return null;
		}
		else
		{
			return customerrepo.save(customer);
		}
		
	}

	@Override
	public Object[] getAllCustomers() {
		
		//return customerrepo.findAll();
		LOGGER.info("Response from MYSQL:{}",customerrepo.selectProcedure());
		return customerrepo.selectProcedure();
	}

	@Override
	public Customer getCustomerById(Long customerId) {
		
		if(customerId.equals(null))
		{
			LOGGER.info("NULL OBJECT");
			return null;
		}
		else
		{
			return customerrepo.findByCustomerId(customerId);
		}
	}

	@Override
	public List<Customer> getCustomersByAddressAndAge(String address, Long age) {
		if(address.equals(null)||age.equals(null))
		{
			LOGGER.info("NULL OBJECT");
			return null;
		}
		else
		{
			return customerrepo.findByCustomerAddressAndAge(address, age);
		}
	}

}
