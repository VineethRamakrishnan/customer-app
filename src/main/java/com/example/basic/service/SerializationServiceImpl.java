package com.example.basic.service;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.basic.data.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SerializationServiceImpl implements SerializationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SerializationServiceImpl.class);

	private final ObjectMapper mapper;

	public SerializationServiceImpl(ObjectMapper mapper) {
		super();
		this.mapper = mapper;
	}

	@Override
	public String doSerialization() throws Exception {

		Customer customer = new Customer(125L, "Srinivasan", "Hyderabad", 30L, 275.85);
		LOGGER.info("Customer Object: {}", customer.toString());
		mapper.writeValue(new File("customer.json"), customer);
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(customer);

	}

	@Override
	public Customer doDeSerialization(String requestJSON) throws Exception {

		LOGGER.info("Request JSON String: {}", requestJSON);
		Customer customer = mapper.readValue(requestJSON, Customer.class);
		return customer;
	}

}
