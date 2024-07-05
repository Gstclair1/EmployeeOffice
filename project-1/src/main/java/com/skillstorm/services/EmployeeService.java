package com.skillstorm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.models.Employee;
import com.skillstorm.repositories.EmployeeRepository;
import com.skillstorm.repositories.OfficeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repo;
	
	@Autowired
	OfficeRepository offRepo;
	
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

		if(repo.getOfficeEmployeeCount(officeId) >= (offRepo.findById(officeId).get().getOfficeCapacity())) {
			System.out.println("capacity reached");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.header("Message", "Office Capacity Reached, cannot add Employee")
					.body(repo.findById(employeeId).get());
		}
		repo.updateEmployeeOffice(officeId, employeeId);
		return this.getEmployeeById(employeeId);
		}
	
	
	public void deleteEmployee(int id) {
		repo.deleteById(id);
	}
}
