package com.example.basic.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.data.Employee;
import com.example.basic.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	private final EmployeeService employeeService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@PostMapping(value = "/create")
	public Employee createEmployee(@RequestBody Employee emp) {

		return employeeService.saveEmployee(emp);

	}

	@GetMapping(value = "/get/{id}")
	public Employee getEmployeeById(@PathVariable("id") Long empId) {

		return employeeService.getEmployeeById(empId);
	}

	@GetMapping(value = "/getAll")
	public List<Employee> getAllEmployee() {

		return employeeService.getAllEmployees();
	}
}
