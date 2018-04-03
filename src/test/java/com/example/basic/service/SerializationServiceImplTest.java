package com.example.basic.service;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.basic.data.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializationServiceImplTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SerializationServiceImplTest.class);
	
	@Test
	 public void deserializeTest() throws Exception {
	    ObjectMapper objectMapper = new ObjectMapper();
	    objectMapper.registerModule(new CustomSerialization());
	 
	    Customer customer= objectMapper.readValue("{\"BasicDetails\": {\"name\": \"Srinivasan\", \"address\": \"Hyderabad\",\"age\": 22, \"customerId\": 125}, \"AddtionalDetails\": { \"customerPoints\": 275.85}}",Customer.class);
	 
	    LOGGER.info("At test side after deserializing the customer object : {}",customer);
	    
	  } 

}
