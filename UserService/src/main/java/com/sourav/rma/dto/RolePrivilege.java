package com.sourav.rma.dto;

import java.util.List;

import com.sourav.rma.entity.Privilege;

public class RolePrivilege {
	
	private long id;
	private String name;
	private List<Privilege> privileges;
	
	public RolePrivilege() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}
	
}
