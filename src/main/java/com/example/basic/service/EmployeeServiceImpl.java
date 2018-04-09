package com.example.basic.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.basic.data.Employee;
import com.example.basic.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepo;

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	public EmployeeServiceImpl(EmployeeRepository employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}

	@Override
	public Employee saveEmployee(Employee emp) {

		return employeeRepo.save(emp);

	}

	@Override
	public List<Employee> getAllEmployees() {

		return employeeRepo.findAll();
	}

	@Override
	public Employee getEmployeeById(Long empId) {

		return employeeRepo.findByEmployeeId(empId);
	}

}
