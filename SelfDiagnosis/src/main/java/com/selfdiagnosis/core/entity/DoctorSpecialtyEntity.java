package com.selfdiagnosis.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DoctorSpecialty")
public class DoctorSpecialtyEntity {
	/**
	 * Primary key
	 */
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	/**
	 * Name of the specialty
	 */
	@Column(name = "name", unique = false, nullable = false)
	private String name;
	
	/**
	 * Description of the specialty
	 */
	@Column(name = "description", unique = false, nullable = true)
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
 

}
