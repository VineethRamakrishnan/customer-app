package com.example.basic.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.basic.data.Customer;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class CustomSerializationImpl extends JsonDeserializer<Customer> {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomSerializationImpl.class);
	
	@Override
	public Customer deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException, JsonProcessingException {
		ObjectCodec objectCodec = jsonParser.getCodec();
		JsonNode jsonNode = objectCodec.readTree(jsonParser);
		
		Customer customer = new Customer();
		
		customer.setCustomerId(jsonNode.get("BasicDetails").get("customerId").asLong());
		customer.setName(jsonNode.get("BasicDetails").get("name").asText());
		customer.setAddress(jsonNode.get("BasicDetails").get("address").asText());
		customer.setAge(jsonNode.get("BasicDetails").get("age").asLong());
		customer.setCustomerPoints(jsonNode.get("AddtionalDetails").get("customerPoints").asDouble());
		
		LOGGER.info("Deserialized object: {}",customer);
		return customer;
	}

}
