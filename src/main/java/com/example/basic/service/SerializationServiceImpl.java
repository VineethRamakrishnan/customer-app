package com.example.basic.service;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.basic.data.Customer;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SerializationServiceImpl extends JsonDeserializer<Customer> implements SerializationService {

	private Customer customer;

	private static final Logger LOGGER = LoggerFactory.getLogger(SerializationServiceImpl.class);

	ObjectMapper mapper = new ObjectMapper();

	@Override
	public String doSerialization() throws Exception {

		customer = new Customer(125L, "Srinivasan", "Hyderabad", 30L, 275.85);
		LOGGER.info("Customer Object: {}", customer.toString());
		mapper.writeValue(new File("customer.json"), customer);
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(customer);
		
	}

	@Override
	public Customer doDeSerialization(String requestJSON) throws Exception {

		LOGGER.info("Request JSON String: {}",requestJSON);
		customer = mapper.readValue(requestJSON, Customer.class);
		return customer;
	}

	@Override
	public Customer deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException, JsonProcessingException {
		ObjectCodec objectCodec = jsonParser.getCodec();
		JsonNode jsonNode = objectCodec.readTree(jsonParser);
		
		customer.setCustomerId(jsonNode.get("BasicDetails").get("customerId").asLong());
		customer.setName(jsonNode.get("BasicDetails").get("name").asText());
		customer.setAddress(jsonNode.get("BasicDetails").get("address").asText());
		customer.setAge(jsonNode.get("BasicDetails").get("age").asLong());
		customer.setCustomerPoints(jsonNode.get("AddtionalDetails").get("customerPoints").asDouble());
		
		LOGGER.info("Deserialized object: {}",customer);
		return customer;
	}

}
