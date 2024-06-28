package com.skillstorm.models;




import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="employee" )
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employee_id")
	private int employeeId;
	
	@Column(name="employee_first_name")
	@NotBlank(message="Must enter employee first name")
	@Size(max = 12, message = "First name must be a maximum of 12 characters")
	private String employeeFirstName;
	
	@Column(name="employee_last_name")
	@NotBlank(message="Must enter employee last name")
	private String employeeLastName;
	
	@Column(name="employee_job_title")
	@NotBlank(message="Must enter employee job title")
	private String employeeJobTitle;
	
	@ManyToOne
	@JoinColumn(name = "office_id", referencedColumnName = "office_id" )
	@JsonIgnoreProperties("employees")
	private Office office;
	
	public Employee() {
		super();
	}

	public Employee(int employeeId,
			@NotBlank(message = "Must enter employee first name") @Size(max = 12, message = "First name must be a maximum of 12 characters") String employeeFirstName,
			@NotBlank(message = "Must enter employee last name") String employeeLastName,
			@NotBlank(message = "Must enter employee job title") String employeeJobTitle, Office office) {
		super();
		this.employeeId = employeeId;
		this.employeeFirstName = employeeFirstName;
		this.employeeLastName = employeeLastName;
		this.employeeJobTitle = employeeJobTitle;
		this.office = office;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeFirstName() {
		return employeeFirstName;
	}

	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}

	public String getEmployeeLastName() {
		return employeeLastName;
	}

	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}

	public String getEmployeeJobTitle() {
		return employeeJobTitle;
	}

	public void setEmployeeJobTitle(String employeeJobTitle) {
		this.employeeJobTitle = employeeJobTitle;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	

	
}
