package com.skillstorm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.models.Office;
import com.skillstorm.repositories.OfficeRepository;

@Service
public class OfficeService {
	
	@Autowired
	OfficeRepository repo;
	
	public Iterable<Office> findAllOffices(){
		return repo.findAll();
	}
	
	public ResponseEntity<Office> getOfficeById(int id){
		if (!repo.existsById(id)) {
			return null;
		}
		return ResponseEntity.status(HttpStatus.OK)
				.header("Message", "Successfully got an office")
				.body(repo.findById(id).get());
	}
	
	public Office createOffice(Office office) {
		if(repo.existsById(office.getOfficeId())) {
			return null;
		}
		return repo.save(office);
	}
	
	public Office updateOffice(Office office) {
		if(!repo.existsById(office.getOfficeId())) {
			return null;
		}
		return repo.save(office);
	}

	public void deleteOffice(int id) {
		repo.deleteById(id);
	}
}
