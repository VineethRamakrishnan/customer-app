package com.example.basic.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.basic.data.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, Long> {

	Employee findByEmployeeId(Long empId);

}
