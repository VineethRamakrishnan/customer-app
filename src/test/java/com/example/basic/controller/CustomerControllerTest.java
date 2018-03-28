package com.example.basic.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.example.basic.data.Customer;
import com.example.basic.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomerControllerTest extends MainControllerTest{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerControllerTest.class);
	
	@Autowired
	protected CustomerRepository customerRepo;

	protected Customer customerFirst;
	protected Customer customerSecond;
	protected Customer customerThird;

	@Before
	public void setData() {

		customerFirst = new Customer(10L, "Vineeth", "Chennai", 22L, 100.25);
		customerSecond = new Customer(20L, "Vikas", "Chennai", 22L, 200.25);
		customerThird = new Customer(30L, "Sudhindra", "Chennai", 23L, 230.25);
		customerRepo.save(customerFirst);
	}
	
	@Test
	public void testCreateCustomer() throws Exception {
		
		String requestJson = new ObjectMapper().writeValueAsString(customerFirst);
		this.mockMvc.perform(post("/customer/create").contentType(MediaType.APPLICATION_JSON_UTF8).content(requestJson))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.address", is("Chennai")));
	}
	
	@Test
	public void testGetAllCustomers() throws Exception {
		
		LOGGER.info("Test Message:{}",customerSecond);
		customerRepo.save(customerSecond);
		
		mockMvc.perform(get("/customer/getAll"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$[1].name").value("Vikas"));
				
	}
	
	/**
	 * Try to pass address and age as params
	 * @throws Exception
	 */
	@Test
	public void testGetCustomersByAddressAndAge() throws Exception {
		
		customerRepo.save(customerSecond);
		customerRepo.save(customerThird);
		
		mockMvc.perform(get("/customer/getByAddressAndAge/Chennai/22"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$",hasSize(2)));
				
	}

}
