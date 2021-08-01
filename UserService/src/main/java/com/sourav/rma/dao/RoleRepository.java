package com.sourav.rma.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sourav.rma.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
	
	Role findByName(String name);

}
