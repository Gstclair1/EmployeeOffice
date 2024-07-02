package com.skillstorm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	public ResponseEntity<Employee> getEmployeeById(int id){
		if(!repo.existsById(id)) {
			return null;
		}
		return ResponseEntity.status(HttpStatus.OK)
				.header("Message", "Successfully got an employee")
				.body(repo.findById(id).get());
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
	
	public ResponseEntity<Employee> updateEmployeeOffice(int employeeId, int officeId) {
		if(!repo.existsById(employeeId)) {
			return null;
		}
		repo.updateEmployeeOffice(officeId, employeeId);
		return this.getEmployeeById(employeeId);
		}
	
	
	public void deleteEmployee(int id) {
		repo.deleteById(id);
	}
}
