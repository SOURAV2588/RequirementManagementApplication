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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String productId;
	private String productName;
	private String domain;
	private String businessAnalyst;
	private String businessProcessOwner;
	private String deliveryManager;
	private String developer;
	private String productOwner;
	private String qualityAnalyst;
	
	@OneToMany(mappedBy = "product")
	List<Requirement> requirements;
	
	//Constructor for JPA
	public Product() {
	}

	public Product(String productId, String productName, String domain) {
		this.productId = productId;
		this.productName = productName;
		this.domain = domain;
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

	public List<Requirement> getRequirements() {
		return requirements;
	}

	public void setRequirements(List<Requirement> requirements) {
		this.requirements = requirements;
	}

	public String getBusinessAnalyst() {
		return businessAnalyst;
	}

	public void setBusinessAnalyst(String businessAnalyst) {
		this.businessAnalyst = businessAnalyst;
	}

	public String getBusinessProcessOwner() {
		return businessProcessOwner;
	}

	public void setBusinessProcessOwner(String businessProcessOwner) {
		this.businessProcessOwner = businessProcessOwner;
	}

	public String getDeliveryManager() {
		return deliveryManager;
	}

	public void setDeliveryManager(String deliveryManager) {
		this.deliveryManager = deliveryManager;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public String getProductOwner() {
		return productOwner;
	}

	public void setProductOwner(String productOwner) {
		this.productOwner = productOwner;
	}

	public String getQualityAnalyst() {
		return qualityAnalyst;
	}

	public void setQualityAnalyst(String qualityAnalyst) {
		this.qualityAnalyst = qualityAnalyst;
	}
	
	
}
