package com.example.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private SerializationService serializationservice;
	
	@GetMapping(value = "/serialization")
	public String convertObjectToJSON() throws Exception {
		
		return serializationservice.doSerialization();
	}
	
	@PostMapping(value = "/deserialization")
	public Customer convertJSONToObject(@RequestBody String requestJSON ) throws Exception {
		
		return serializationservice.doDeSerialization(requestJSON);
	}

	
}
