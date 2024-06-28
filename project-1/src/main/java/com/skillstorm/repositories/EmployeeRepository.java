package com.skillstorm.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.models.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

	@Query(value="UPDATE employee SET office_id = ?2 WHERE employee_id = ?1", nativeQuery = true)
	public void updateEmployeeOffice(int employeeId, int officeId);
}
