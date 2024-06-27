package com.skillstorm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	
	@PostMapping
	public Employee addEmployee(@Valid @RequestBody Employee employee) {
		return service.createEmployee(employee);
	}
	
	@PutMapping
	public Employee updateEmployee(@Valid @RequestBody Employee employee) {
		return service.updateEmployee(employee);
	}
	
	
}
