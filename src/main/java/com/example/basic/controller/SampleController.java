package com.example.basic.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {

	@RequestMapping(method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> getVariant() {
		
		return new ResponseEntity<String>("This is from first variant", HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE,headers = "X-Version=2.0")
	public @ResponseBody ResponseEntity<String> getVariantV1() {
		
		return new ResponseEntity<String>("This is from second variant", HttpStatus.OK);
	}
}
