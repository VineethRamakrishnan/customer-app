package com.example.basic.service;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.stereotype.Service;

import com.example.basic.data.Employee;
import com.example.basic.dto.EmployeeDTO;
import com.example.basic.repository.EmployeeRepository;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepo;

	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	private MongoClient mongo;
	private DB database;
	private DBCollection col;

	public EmployeeServiceImpl(EmployeeRepository employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
		setupConnection();
	}

	private void setupConnection() {

		this.mongo = new MongoClient("localhost", 27017);
		this.database = mongo.getDB("sample");
		this.col = database.getCollection("Employee");

		if (LOGGER.isInfoEnabled()) {

			LOGGER.info("Connection to Employee table in sample database has been established...");
		}
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

	public List<Employee> getAllEmployeeByMongoClient() {

		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("Getting All Employees by MongoClient...");
		}

		/*
		 * Using SimpleMongoDbFactory but error! SimpleMongoDbFactory databaseFactory =
		 * new SimpleMongoDbFactory(mongo, "sample"); DBCollection col =
		 * databaseFactory.getDb().getCollection("Employee");
		 * 
		 */
		List<Employee> allEmployees = new ArrayList();
		DBCursor cursor = col.find();
		while (cursor.hasNext()) {

			if (LOGGER.isInfoEnabled()) {

				LOGGER.info("Documents:{}", cursor.next());
			}

			cursor.next();
			Employee emp = new Employee();

			emp.setEmployeeId((Long) cursor.curr().get("_id"));
			emp.setEmployeeName((String) cursor.curr().get("emp_name"));
			emp.setEmployeeAddress((String) cursor.curr().get("emp_address"));
			allEmployees.add(emp);

		}

		return allEmployees;
	}

	@Override
	public Employee getEmployeeByMongoClient(String employeeName) {

		Employee emp = new Employee();
		BasicDBObject fields = new BasicDBObject();
		fields.put("emp_name", employeeName);
		DBCursor cursor = col.find(fields);

		while (cursor.hasNext()) {
			cursor.next();
			emp.setEmployeeId((Long) cursor.curr().get("_id"));
			emp.setEmployeeName((String) cursor.curr().get("emp_name"));
			emp.setEmployeeAddress((String) cursor.curr().get("emp_address"));
		}

		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("Retrieved employee : {}", emp.toString());
		}
		return emp;
	}

	@Override
	public String saveEmployeeByMongoClient(Employee emp) {

		DBObject doc = createDBObject(emp);

		WriteResult result = col.insert(doc);
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("Result after storing an employee: {}", result);
		}
		return "Successfully inserted..!!";
	}

	/**
	 * Need to Implement!
	 */
	@Override
	public String saveEmployeesByMongoClient(List<Employee> empList) {

		DBObject doc = createDBObjects(empList);

		WriteResult result = col.insert(doc);
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("Result after storing an employee: {}", result);
		}
		return "Successfully inserted..!!";
	}

	@Override
	public String updateEmployeeByMongoClient(Employee newEmployee) {

		DBObject doc = createDBObject(newEmployee);
		DBObject query = BasicDBObjectBuilder.start().add("_id", newEmployee.getEmployeeId()).get();

		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("Object to be updated: {}", doc);
			LOGGER.info("Extracted object: {}", query);
		}
		WriteResult result = col.update(query, doc);

		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("Result after updating an employee: {}", result);
		}
		return "Successfully updated..!!";

	}

	@Override
	public String deleteEmployeeByMongoClient(Long empId) {

		if (LOGGER.isInfoEnabled())
			LOGGER.info("empId received at service: {}", empId);

		DBObject query = BasicDBObjectBuilder.start().add("_id", empId).get();
		WriteResult result = col.remove(query);

		if (LOGGER.isInfoEnabled())
			LOGGER.info("Result after removing an employee: {}", result);

		return "Successfully deleted..!!";
	}

	private static DBObject createDBObject(Employee emp) {

		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();

		docBuilder.append("_id", emp.getEmployeeId());
		docBuilder.append("emp_name", emp.getEmployeeName());
		docBuilder.append("emp_address", emp.getEmployeeAddress());

		return docBuilder.get();
	}

	/**
	 * For saving multiple objects - Need to Implement!!
	 * 
	 * @param empList
	 * @return
	 */
	private static DBObject createDBObjects(List<Employee> empList) {

		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
		List<BasicDBObject> docBuilderList = new ArrayList<>();

		for (int i = 0; i <= empList.size(); i++) {
			Employee emp = empList.get(i);
			docBuilder.append("_id", emp.getEmployeeId());
			docBuilder.append("emp_name", emp.getEmployeeName());
			docBuilder.append("emp_address", emp.getEmployeeAddress());

			// docBuilderList.add(docBuilder);
		}

		return docBuilder.get();
	}

}
