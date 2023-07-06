package com.dynomo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dynomo.demo.entity.Employee;
import com.dynomo.demo.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@PostMapping()
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeRepository.saveEmployee(employee);
	}

	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable("id") String employeeId) {
		return employeeRepository.getEmployeeById(employeeId);
	}

	@DeleteMapping("/{id}")
	public String deleteEmployeeById(@PathVariable("id") String employeeId) {
		return employeeRepository.deleteEmployeeById(employeeId);
	}

	@PutMapping("/{id}")
	public String updateEmployee(@PathVariable("id") String employeeId, @RequestBody Employee employee) {
		return employeeRepository.updateEmployee(employeeId, employee);
	}

}
