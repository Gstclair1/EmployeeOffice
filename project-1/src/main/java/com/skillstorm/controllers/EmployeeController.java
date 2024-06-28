package com.skillstorm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.models.Employee;
import com.skillstorm.services.EmployeeService;

import jakarta.validation.Constraint;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@GetMapping
	public Iterable<Employee> getAllEmployees(){
		return service.findAllEmployees();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
		return service.getEmployeeById(id);
	}
	
	
	@PostMapping
	public Employee addEmployee(@Valid @RequestBody Employee employee) {
		return service.createEmployee(employee);
	}
	
	@PutMapping
	public Employee updateEmployee(@Valid @RequestBody Employee employee) {
		return service.updateEmployee(employee);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployeeOffice(@PathVariable int employeeId /**@RequestParam int officeId*/){
		return service.updateEmployeeOffice(employeeId, 1);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable int id) {
		service.deleteEmployee(id);
	}
	
}
