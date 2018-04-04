package com.example.basic.service;

import org.springframework.stereotype.Service;

import com.example.basic.data.Customer;
import com.fasterxml.jackson.databind.module.SimpleModule;

@Service
public class CustomSerialization extends SimpleModule {

	public CustomSerialization() {
			this.addDeserializer(Customer.class, new CustomSerializationImpl());
	}

}
