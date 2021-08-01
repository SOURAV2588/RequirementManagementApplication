package com.sourav.rma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sourav.rma.dto.PrivilegeDto;
import com.sourav.rma.dto.RolePrivilege;
import com.sourav.rma.entity.Role;
import com.sourav.rma.service.PrivilageService;
import com.sourav.rma.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleRestController {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private PrivilageService privilageService;

	@PostMapping
	public void createRole(@RequestBody RolePrivilege rolePrivilege) {
		Role role = new Role();
		role.setId(rolePrivilege.getId());
		role.setName(rolePrivilege.getName());
		role.setPrivileges(rolePrivilege.getPrivileges());
		roleService.createRole(role);
	}
	
	@PostMapping("/{roleName}/addPrivilege")
	public void addPrivilegesToRole(@PathVariable("roleName") String roleName, PrivilegeDto privilegeDto) {
		roleService.addPrivilegesToRole(roleName, privilegeDto);
	}

	@DeleteMapping("/{id}")
	public void deleteRole(@PathVariable long id) {
		roleService.deleteRole(id);
	}
}
