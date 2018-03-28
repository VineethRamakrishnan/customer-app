package com.example.basic.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import com.example.basic.data.Retailer;

@Service
@ConfigurationProperties(prefix = "prop")
public class RetailerServiceImpl {

	private List<Retailer> retailerList = new ArrayList<>();

	private static final Logger LOGGER = LoggerFactory.getLogger(RetailerServiceImpl.class);
	
	public List<Retailer> getAllRetailers() {

		LOGGER.info("retrieved objects: {}",retailerList.toString());
		return retailerList;
	}

}
