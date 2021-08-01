package com.sourav.rma.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Requirement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String requirementId;
	private String requirementName;
	private String requirementDescription;
	private String requirementOwner;
	private String taskOwner;
	private String requirementState;
	
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
				fetch = FetchType.LAZY)		
	@JoinColumn(name = "product_id")
	@JsonIgnore
	private Product product;
	
	/**
	 * JPA
	 */
	public Requirement() {
		
	}

	public Requirement(String requirementName, String requirementDescription, String requirementOwner) {
		this.requirementName = requirementName;
		this.requirementDescription = requirementDescription;
		this.requirementOwner = requirementOwner;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRequirementId() {
		return requirementId;
	}

	public void setRequirementId(String requirementId) {
		this.requirementId = requirementId;
	}

	public String getRequirementName() {
		return requirementName;
	}

	public void setRequirementName(String requirementName) {
		this.requirementName = requirementName;
	}

	public String getRequirementDescription() {
		return requirementDescription;
	}

	public void setRequirementDescription(String requirementDescription) {
		this.requirementDescription = requirementDescription;
	}

	public String getTaskOwner() {
		return taskOwner;
	}

	public void setTaskOwner(String taskOwner) {
		this.taskOwner = taskOwner;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getRequirementState() {
		return requirementState;
	}

	public void setRequirementState(String requirementState) {
		this.requirementState = requirementState;
	}

	public String getRequirementOwner() {
		return requirementOwner;
	}

	public void setRequirementOwner(String requirementOwner) {
		this.requirementOwner = requirementOwner;
	}
}