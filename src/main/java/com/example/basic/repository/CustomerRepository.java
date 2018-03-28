package com.example.basic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.basic.data.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer save(Customer customer);

	@Query("Select c from Customer c")
	List<Customer> findAll();

	/**
	 * Example for JPQL - Java Persistence Query Language
	 * @param customerId
	 * @return
	 */
	@Query("select c from Customer c where c.customerId = ?1")
	Customer findByCustomerId(Long customerId);

	/**
	 * Example for SQL - Structured Query Language 
	 * @param customerAddress
	 * @param customerAge
	 * @return
	 */
	@Query(value = "select * from customer_sample where address = :address and age = :age",nativeQuery = true)
	List<Customer> findByCustomerAddressAndAge(@Param("address") String customerAddress,@Param("age") Long customerAge);
}
