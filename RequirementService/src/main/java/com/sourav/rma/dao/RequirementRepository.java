package com.sourav.rma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sourav.rma.entity.Requirement;

public interface RequirementRepository extends CrudRepository<Requirement, Long> {
	
	@Override
	public List<Requirement> findAll();
	
	@Query(nativeQuery = true, value="SELECT REQUIREMENT_ID FROM REQUIREMENT ORDER BY REQUIREMENT_ID DESC LIMIT 1")
	public String getLastRequirementId();

}
