/**
 * 
 */
package com.sourav.rma.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sourav.rma.dao.PrivilegeRepository;
import com.sourav.rma.dao.RoleRepository;
import com.sourav.rma.entity.ActorPrivileges;
import com.sourav.rma.entity.Privilege;
import com.sourav.rma.entity.Role;

/**
 * @author dell
 *
 */
@Component
public class RolePrivilegeInitializer {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PrivilegeRepository privilegeRepository;

	@PostConstruct
	public void initializeRoleWithPrivileges() {
		for (ActorPrivileges actorPrivilege : ActorPrivileges.values()) {
			String roleName = actorPrivilege.name();
			Set<String> privilegeSet = actorPrivilege.getPrivileges();
			List<Privilege> newPrivileges = createPrivileges(privilegeSet);
			Role role = new Role();
			role.setName(roleName);
			role.setPrivileges(newPrivileges);
			roleRepository.save(role);
		}
	}
	
	private List<Privilege> createPrivileges(Set<String> privilegeSet) {
		List<Privilege> newPrivileges = new ArrayList<Privilege>();
		for (String priv : privilegeSet) {
			Privilege privilege = privilegeRepository.findByName(priv);
			if(privilege == null) {
				privilege =  new Privilege();
				privilege.setName(priv);
				privilegeRepository.save(privilege);
			}
			newPrivileges.add(privilege);
		}
		return newPrivileges;
	}

}
