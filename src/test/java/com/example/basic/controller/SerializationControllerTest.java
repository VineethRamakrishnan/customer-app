package com.example.basic.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;

import com.example.basic.data.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializationControllerTest extends MainControllerTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(SerializationControllerTest.class);

	@Test
	public void testConvertObjectToJSON() throws Exception {
		
		String resultString = "{\r\n" + 
				"  \"customerId\" : 125,\r\n" + 
				"  \"name\" : \"Srinivasan\",\r\n" + 
				"  \"address\" : \"Hyderabad\",\r\n" + 
				"  \"age\" : 30,\r\n" + 
				"  \"customerPoints\" : 275.85\r\n" + 
				"}";
		
		this.mockMvc.perform(get("/jackson/serialization"))
						.andDo(print())
						.andExpect(status().isOk())
						.andExpect(content().string(resultString));
	}
	
	@Test
	public void testConvertJSONToObject() throws Exception {
		
		String requestCustomer = new ObjectMapper().writeValueAsString(new Customer(10L, "Vineeth", "Chennai", 22L, 75.5));
		this.mockMvc.perform(post("/jackson/deserialization").contentType(MediaType.APPLICATION_JSON_UTF8).content(requestCustomer))
						.andDo(print())
						.andExpect(status().isOk())
						.andExpect(jsonPath("$.address", is("Chennai")));
	}
}
