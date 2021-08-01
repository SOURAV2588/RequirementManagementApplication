package com.sourav.rma.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String productId;
	private String productName;
	private String domain;
	private String productManager;
	
//	@OneToMany(mappedBy = "product")
//	List<Requirement> requirements;
	
	//Constructor for JPA
	public Product() {
	}

	public Product(String productId, String productName, String domain, String productManager) {
		this.productId = productId;
		this.productName = productName;
		this.domain = domain;
		this.productManager = productManager;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getProductManager() {
		return productManager;
	}

	public void setProductManager(String productManager) {
		this.productManager = productManager;
	}

//	public List<Requirement> getRequirements() {
//		return requirements;
//	}
//
//	public void setRequirements(List<Requirement> requirements) {
//		this.requirements = requirements;
//	}
}
