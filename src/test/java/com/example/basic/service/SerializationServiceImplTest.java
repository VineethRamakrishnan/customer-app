package com.example.basic.service;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.basic.data.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;

import junit.framework.Assert;

public class SerializationServiceImplTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SerializationServiceImplTest.class);
	
	@Test
	 public void deserializeTest() throws Exception {
	    
		String requestString = "{\"BasicDetails\": {\"name\": \"Srinivasan\", \"address\": \"Hyderabad\",\"age\": 22, \"customerId\": 125}, \"AddtionalDetails\": { \"customerPoints\": 275.85}}";
		
		ObjectMapper objectMapper = new ObjectMapper();
	    objectMapper.registerModule(new CustomSerialization());
	 
	    
	    Customer customer= objectMapper.readValue(requestString,Customer.class);
	    Customer customerSecond = new Customer(125L, "Srinivasan", "Hyderabad", 22L, 275.85);
	    
	    LOGGER.info("At test side after deserializing the customer object : {}",customer);
	    
	    Assert.assertEquals(customer.toString(), customerSecond.toString());
	  
	  } 

}
