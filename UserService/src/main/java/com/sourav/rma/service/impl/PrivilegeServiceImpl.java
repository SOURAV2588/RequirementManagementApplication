package com.sourav.rma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourav.rma.dao.PrivilegeRepository;
import com.sourav.rma.entity.Privilege;
import com.sourav.rma.service.PrivilageService;

@Service
public class PrivilegeServiceImpl implements PrivilageService {
	
	@Autowired
	private PrivilegeRepository privilegeRepository;

	@Override
	public Privilege createPrivilege(Privilege privilege) {
		return privilegeRepository.save(privilege);
	}

}
