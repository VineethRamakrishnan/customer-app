package com.example.basic.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;

public class ConfigurationControllerTest extends MainControllerTest {

	@Test
	public void testGetIpAddress() throws Exception {

		mockMvc.perform(get("/config/ipaddress")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string("localhost"));
	}

	@Test
	public void testGetEnvironment() throws Exception {

		mockMvc.perform(get("/config/environment")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string("development"));

	}
}
