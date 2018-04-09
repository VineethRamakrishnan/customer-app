package com.example.basic.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.data.Retailer;
import com.example.basic.service.RetailerServiceImpl;

@RestController
@RequestMapping("/retailer")
public class ServerConfigurationController {

	private final RetailerServiceImpl serviceImpl;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ServerConfigurationController.class);

	public ServerConfigurationController(RetailerServiceImpl serviceImpl) {
		super();
		this.serviceImpl = serviceImpl;
	}

	@GetMapping("/getAll")
	public List<Retailer> getIpAddress() {

		return serviceImpl.getRetailers();
	}

}
