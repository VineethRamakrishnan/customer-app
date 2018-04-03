package com.example.basic.service;

import com.example.basic.data.Customer;

public interface SerializationService {

	/**
	 * Java to JSON
	 * @return
	 * @throws Exception 
	 */
	String doSerialization() throws Exception;
	
	/**
	 * JSON to Java
	 * @return
	 */
	Customer doDeSerialization( String requestJSON) throws Exception;
}
