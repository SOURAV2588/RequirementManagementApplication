package com.sourav.rma.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourav.rma.dao.PrivilegeRepository;
import com.sourav.rma.dao.RoleRepository;
import com.sourav.rma.dto.PrivilegeDto;
import com.sourav.rma.entity.Privilege;
import com.sourav.rma.entity.Role;
import com.sourav.rma.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PrivilegeRepository privilegeRepository;

	@Override
	public Role createRole(Role role) {
		return roleRepository.save(role);		
	}
	
	@Override
	public Role findRoleById(long id) {
		Optional<Role> optionalRole = roleRepository.findById(id);
		return optionalRole.get();
	}

	@Override
	public void deleteRole(long id) {
		roleRepository.deleteById(id);
	}

	@Override
	public void updateRole(long id, Role updatedRole) {
		Role role = roleRepository.findById(id).get();
		role.setPrivileges(updatedRole.getPrivileges());
		roleRepository.save(role);
	}

	@Override
	public void addPrivilegesToRole(String roleName, PrivilegeDto privilegeDto) {
		List<String> newPrivileges = privilegeDto.getPrivileges();
		//TODO - Make sure Role must exist
		Role role = roleRepository.findByName(roleName);
		List<Privilege> privileges = new ArrayList<Privilege>();
		
		for(String privilege : newPrivileges) {
			
		}
	}
}
