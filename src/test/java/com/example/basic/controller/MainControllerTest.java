package com.example.basic.controller;

import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import com.example.basic.AbstractSpringRunner;
import com.example.basic.data.Customer;
import com.example.basic.repository.CustomerRepository;

@AutoConfigureMockMvc
public class MainControllerTest extends AbstractSpringRunner{

	@Autowired
	protected MockMvc mockMvc;
	
	@Autowired
	protected CustomerRepository customerRepo;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MainControllerTest.class);
	
	protected Customer customerFirst;
	protected Customer customerSecond;
	protected Customer customerThird;
	
	@Before
	public void setData() {
		
		customerFirst = new Customer(10L,"Vineeth","Chennai",22L,100.25);
		customerSecond = new Customer(20L,"Vikas","Chennai",22L,200.25);
		customerThird = new Customer(30L,"Sudhindra","Chennai",23L,230.25);
		
		LOGGER.info("Object:{}",customerFirst.toString());
		customerRepo.save(customerFirst);
	}
	
}
