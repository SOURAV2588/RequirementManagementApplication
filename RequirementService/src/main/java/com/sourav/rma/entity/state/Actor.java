/**
 * 
 */
package com.sourav.rma.entity.state;

/**
 * @author dell
 *
 */
public enum Actor {
	
	PRODUCT_OWNER("ProductOwner"),
	BUSINESS_PROCESS_OWNER("BusinessProcessOwner"),
	BUSINESS_ANALYST("BusinessAnalyst"),
	DEVELOPER("Developer"),
	QUALITY_ANALYST("QualityAnalyst"),
	DELIVERY_MANAGER("DeliveryManager"),
	REQUIREMENT_OWNER("RequirementOwner");
	
	private String actorName;

	private Actor(String actorName) {
		this.actorName = actorName;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}
	
}
