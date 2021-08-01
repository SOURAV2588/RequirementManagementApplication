/**
 * 
 */
package com.sourav.rma.entity;

/**
 * @author dell
 *
 */
public enum Privileges {

	CREATE_PRODUCT("Create Product"),
	READ_PRODUCT("Read Product"),
	UPDATE_PRODUCT("Update Product"),
	DELETE_PRODUCT("Delete Product"),
	CREATE_REQUIREMENT("Create Requirement"),
	READ_REQUIREMENT("Read Requirement"),
	UPDATE_REQUIREMENT("Update Requirement"),
	DELETE_REQUIREMENT("Delete Requirement"),
	CREATE_USER("Create User"),
	READ_USER("Read User"),
	UPDATE_USER("Update User"),
	DELETE_USER("Delete User");
	
	private String privilegeName;
	
	private Privileges(String privilegeName) {
		this.privilegeName = privilegeName;
	}

	public String getPrivilegeName() {
		return privilegeName;
	}

	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}
	
}
