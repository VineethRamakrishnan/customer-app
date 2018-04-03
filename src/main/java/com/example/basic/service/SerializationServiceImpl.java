package com.example.basic.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.basic.data.Customer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SerializationServiceImpl implements SerializationService {

	private Customer customer;

	private static final Logger LOGGER = LoggerFactory.getLogger(SerializationServiceImpl.class);

	ObjectMapper mapper = new ObjectMapper();

	@Override
	public String doSerialization() throws Exception {

		customer = new Customer(125L, "Srinivasan", "Hyderabad", 30L, 275.85);
		LOGGER.info("Customer Object: {}", customer.toString());
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(customer);
		
	}

	@Override
	public Customer doDeSerialization(String requestJSON) throws Exception {

		LOGGER.info("Request JSON String: {}",requestJSON);
		customer = mapper.readValue(requestJSON, Customer.class);
		return customer;
	}

}
