package com.example.basic.service;

import java.util.List;

import com.example.basic.data.Employee;

public interface EmployeeService {
	
	Employee saveEmployee(Employee emp);
	
	List<Employee> getAllEmployees();
	
	Employee getEmployeeById(Long empId);
	
}
