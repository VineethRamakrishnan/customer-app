package com.example.basic.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import com.example.basic.data.Retailer;

@Service
//@ConfigurationProperties(prefix = "prop")
public class RetailerServiceImpl {

	private List<Retailer> retailers;

	private static final Logger LOGGER = LoggerFactory.getLogger(RetailerServiceImpl.class);

	public List<Retailer> getRetailers() {
		LOGGER.info("List of retailers: {}", retailers.toString());
		return retailers;
	}

	public void setRetailers(List<Retailer> retailers) {
		this.retailers = retailers;
	}

	public RetailerServiceImpl(List<Retailer> retailers) {
		super();
		this.retailers = retailers;
	}

	public RetailerServiceImpl() {
		super();
		
	}

	
	
}
