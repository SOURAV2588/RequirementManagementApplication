package com.sourav.rma.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sourav.rma.entity.Privilege;

@Repository
public interface PrivilegeRepository extends CrudRepository<Privilege, Long> {

	public Privilege findByName(String name);
}
