package com.skillstorm.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.models.Employee;

@Repository
@Transactional
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

	@Modifying
	@Query(value="UPDATE employee SET office_id = ?1 WHERE employee_id = ?2", nativeQuery = true)
	public void updateEmployeeOffice(Integer officeId,  Integer employee_id);
	
	@Query(value="SELECT COUNT(employee_id) FROM employee WHERE office_id = ?1", nativeQuery=true)
	public int getOfficeEmployeeCount(Integer officeId);
	
}
