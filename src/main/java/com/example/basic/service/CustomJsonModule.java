package com.example.basic.service;

import com.example.basic.data.Customer;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * @Service
 * @author v.rama.krishnan
 *
 */

public class CustomJsonModule extends SimpleModule {

	public CustomJsonModule() {
			this.addDeserializer(Customer.class, new CustomSerializationImpl());
	}

}
