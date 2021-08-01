package com.sourav.rma.service;

import com.sourav.rma.dto.PrivilegeDto;
import com.sourav.rma.entity.Role;

public interface RoleService {
	
	Role createRole(Role role);
	
	void deleteRole(long id);

	Role findRoleById(long id);

	void updateRole(long id, Role role);

	void addPrivilegesToRole(String roleName, PrivilegeDto privilegeDto);

}
