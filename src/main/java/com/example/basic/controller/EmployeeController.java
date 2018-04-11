package com.example.basic.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.data.Employee;
import com.example.basic.dto.EmployeeDTO;
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
	
	@GetMapping(value="/getAllByMongoClient")
	public List<Employee> getAllEmployeesUsingMongoClient() {
		return employeeService.getAllEmployeeByMongoClient();
	}
	
	@GetMapping(value = "/getByMongoClient/{name}")
	public Employee getEmployeeUsingMongoClient(@PathVariable("name") String employeeName) {
		
		return employeeService.getEmployeeByMongoClient(employeeName);
	}
	
	@PostMapping(value = "/saveByMongoClient")
	public String saveEmployeeUSingMongoClient(@RequestBody Employee emp) {
		
		 return employeeService.saveEmployeeByMongoClient(emp);
	}
	
	@PutMapping(value = "/updateByMongoClient")
	public String updateEmployeeByMongoClient(@RequestBody Employee emp) {
		
		return employeeService.updateEmployeeByMongoClient(emp);
	}
	
	@DeleteMapping(value = "/deleteByMongoClient/{id}")
	public String deleteEmployeeByMongoClient(@PathVariable Long id) {
		
		if(LOGGER.isInfoEnabled()) {
			LOGGER.info("Delete has been called with id value: {}",id);
		}
		return employeeService.deleteEmployeeByMongoClient(id);
	}
}
