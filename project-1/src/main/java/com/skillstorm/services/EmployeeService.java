package com.skillstorm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.models.Employee;
import com.skillstorm.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repo;
	
	public Iterable<Employee> findAllEmployees(){
		return repo.findAll();	
	}
	
	public Employee createEmployee(Employee emp) {
		if(repo.existsById(emp.getEmployeeId())) {
			return null;
		}
		return repo.save(emp);
	}
	
	public Employee updateEmployee(Employee emp) {
		if(!repo.existsById(emp.getEmployeeId())) {
			return null;
		}
		return repo.save(emp);
	}
	
}
