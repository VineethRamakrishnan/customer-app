package com.example.basic.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.basic.data.Customer;
import com.example.basic.repository.CustomerRepository;

@Service
public class CustomerServiceUtility implements CustomerService {

	private final CustomerRepository customerrepo;

	@PersistenceContext
	private EntityManager entityManager;

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceUtility.class);

	public CustomerServiceUtility(CustomerRepository customerrepo, EntityManager entityManager) {
		super();
		this.customerrepo = customerrepo;
		this.entityManager = entityManager;
	}

	@Override
	public Customer saveCustomer(Customer customer) {

		if (customer.equals(null)) {
			LOGGER.info("NULL OBJECT");
			return null;
		} else {
			return customerrepo.save(customer);
		}

	}

	@Override
	public List<Customer> getAllCustomers() {

		return customerrepo.findAll();

	}

	@Override
	public Customer getCustomerById(Long customerId) {

		if (customerId.equals(null)) {
			LOGGER.info("NULL OBJECT");
			return null;
		} else {
			return customerrepo.findByCustomerId(customerId);
		}
	}

	@Override
	public List<Customer> getCustomersByAddressAndAge(String address, Long age) {
		if (address.equals(null) || age.equals(null)) {
			LOGGER.info("NULL OBJECT");
			return null;
		} else {
			return customerrepo.findByCustomerAddressAndAge(address, age);
		}
	}

	@Override
	public List<Customer> getAllCustomersByStoredProcedure() {

		StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("select_procedure");
		query.execute();
		LOGGER.info("Result set of query: {}", query.getResultList());
		return query.getResultList();
	}

	@Override
	public List<Customer> getAllCustomersByCustomQuery() {

		return customerrepo.findAllByCustomQuery();
	}

	@Override
	public Customer updateCustomersByStoredProcedure(Long customer_id, Double customer_pts) {

		StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("update_procedure");
		query.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, Double.class, ParameterMode.IN);

		query.setParameter(1, customer_id);
		query.setParameter(2, customer_pts);

		query.execute();

		return (Customer) query.getSingleResult();
	}

}
