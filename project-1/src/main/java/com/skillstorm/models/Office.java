package com.skillstorm.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "office")
public class Office {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "office_id")
	private int officeId;
	
	@Column(name="office_name")
	private String officeName;
	
	@Column(name="office_address")
	private String officeAddress;
	
	@Column(name="office_capacity")
	private int officeCapacity;
	
	public Office() {
		super();
	}

	public Office(int officeId, String officeName, String officeAddress, int officeCapacity) {
		super();
		this.officeId = officeId;
		this.officeName = officeName;
		this.officeAddress = officeAddress;
		this.officeCapacity = officeCapacity;
	}

	public int getOfficeId() {
		return officeId;
	}

	public void setOfficeId(int officeId) {
		this.officeId = officeId;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public String getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	public int getOfficeCapacity() {
		return officeCapacity;
	}

	public void setOfficeCapacity(int officeCapacity) {
		this.officeCapacity = officeCapacity;
	}

}
