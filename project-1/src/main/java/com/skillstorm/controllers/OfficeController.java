package com.skillstorm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.models.Office;
import com.skillstorm.services.OfficeService;

@RestController
@RequestMapping("/office")
@CrossOrigin(origins = "*")
public class OfficeController {
	
	@Autowired
	OfficeService service;
	
	@GetMapping
	public Iterable<Office> getAllOffices(){
		return service.findAllOffices();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Office> getOfficeById(@PathVariable int id){
		return service.getOfficeById(id);
	}
	
	@PostMapping
	public Office addOffice(@RequestBody Office office) {
		return service.createOffice(office);
	}
	
	@PutMapping
	public Office updateOffice(@RequestBody Office office) {
		return service.updateOffice(office);
	}
	
	@DeleteMapping("/{id}")
	public void deleteOffice(@PathVariable int id) {
		service.deleteOffice(id);
	}
}
