package com.example.basic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.data.Customer;
import com.example.basic.service.SerializationService;

@RestController
@RequestMapping("/jackson")
public class SerializationController {
	
	private final SerializationService serializationservice;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SerializationController.class);
	
	public SerializationController(SerializationService serializationservice) {
		super();
		this.serializationservice = serializationservice;
	}

	@GetMapping(value = "/serialization")
	public String convertObjectToJSON() throws Exception {
		
		return serializationservice.doSerialization();
	}
	
	@PostMapping(value = "/deserialization")
	public Customer convertJSONToObject(@RequestBody String requestJSON ) throws Exception {
		
		return serializationservice.doDeSerialization(requestJSON);
	}

	
}
