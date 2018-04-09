package com.example.basic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.service.ConfigurationServiceImpl;

@RestController
@RequestMapping("/config")
public class ConfigurationController {

	private final ConfigurationServiceImpl serviceImpl;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ConfigurationController.class);

	public ConfigurationController(ConfigurationServiceImpl serviceImpl) {
		super();
		this.serviceImpl = serviceImpl;
	}

	@GetMapping("/ipaddress")
	public String getIpAddress() {

		return serviceImpl.getIpAddress();
	}
	
	@GetMapping("/environment")
	public String getEnvironment() {

		return serviceImpl.getEnvironment();
	}

}
