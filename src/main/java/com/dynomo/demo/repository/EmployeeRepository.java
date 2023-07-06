package com.dynomo.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.dynomo.demo.entity.Employee;

@Repository
public class EmployeeRepository {

	@Autowired
	private DynamoDBMapper dynamoDBMapper;

	public Employee saveEmployee(Employee employee) {
		dynamoDBMapper.save(employee);
		return employee;
	}

	public Employee getEmployeeById(String id) {
		return dynamoDBMapper.load(Employee.class, id);
	}

	public String deleteEmployeeById(String id) {
		dynamoDBMapper.delete(dynamoDBMapper.load(Employee.class, id));
		return "Employee Id : " + id + " Deleted!";
	}

	public String updateEmployee(String id, Employee employee) {
		dynamoDBMapper.save(employee, new DynamoDBSaveExpression().withExpectedEntry("id",
				new ExpectedAttributeValue(new AttributeValue().withS(id))));
		return id;
	}
}