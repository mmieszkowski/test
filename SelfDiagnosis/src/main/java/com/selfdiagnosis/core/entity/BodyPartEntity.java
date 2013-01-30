package com.selfdiagnosis.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BodyPart")
public class BodyPartEntity {
	/**
	 * Primary key
	 */
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	/**
	 * Name of the test type
	 */
	@Column(name = "name", unique = false, nullable = false)
	private String name;

	/**
	 * Parent body part. I.e head for the eyes
	 */
	@ManyToOne
	@JoinColumn(name = "parentBodyPart_id", nullable = true)
	private BodyPartEntity parentBodyPart;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BodyPartEntity getParentBodyPart() {
		return parentBodyPart;
	}

	public void setParentBodyPart(BodyPartEntity parentBodyPart) {
		this.parentBodyPart = parentBodyPart;
	}
}