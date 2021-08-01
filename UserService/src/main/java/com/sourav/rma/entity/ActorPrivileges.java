/**
 * 
 */
package com.sourav.rma.entity;

import java.util.HashSet;
import java.util.Set;

import static com.sourav.rma.entity.Privileges.*;

/**
 * @author dell
 *
 */
public enum ActorPrivileges {
	
	PRODUCT_ADMIN(CREATE_PRODUCT, READ_PRODUCT, UPDATE_PRODUCT, DELETE_PRODUCT),
	
	USER_ADMIN(CREATE_USER, READ_USER, UPDATE_USER, DELETE_USER),

	PRODUCT_OWNER(READ_PRODUCT, UPDATE_PRODUCT, CREATE_REQUIREMENT, READ_REQUIREMENT, UPDATE_REQUIREMENT,
			DELETE_REQUIREMENT),
	
	BUSINESS_PROCESS_OWNER(CREATE_REQUIREMENT, READ_REQUIREMENT, UPDATE_REQUIREMENT),
	
	BUSINESS_ANALYST(READ_REQUIREMENT, UPDATE_REQUIREMENT),
	
	DEVELOPER(READ_REQUIREMENT, UPDATE_REQUIREMENT),
	
	QUALITY_ANALYST(READ_REQUIREMENT, UPDATE_REQUIREMENT), 
	
	DELIVERY_MANAGER(READ_REQUIREMENT, UPDATE_REQUIREMENT),
	
	REQUIREMENT_OWNER(READ_REQUIREMENT, UPDATE_REQUIREMENT);
	

	private Set<String> privileges;

	private ActorPrivileges(Privileges... eprivileges) {
		this.privileges = new HashSet<>();
		for (Privileges privilege : eprivileges) {
			privileges.add(privilege.getPrivilegeName());
		}
	}

	public Set<String> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Set<String> privileges) {
		this.privileges = privileges;
	}

}
