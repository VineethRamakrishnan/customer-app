package com.example.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import com.example.basic.AbstractSpringRunner;

@AutoConfigureMockMvc
public class MainControllerTest extends AbstractSpringRunner {

	@Autowired
	protected MockMvc mockMvc;

}
