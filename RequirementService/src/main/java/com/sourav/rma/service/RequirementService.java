package com.sourav.rma.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourav.rma.dao.RequirementRepository;
import com.sourav.rma.dao.UsersServiceClient;
import com.sourav.rma.entity.Requirement;
import com.sourav.rma.entity.state.RequirementState;

/**
 * 
 * @author Sourav Ghosh
 *
 */
@Service
public class RequirementService {
	
	@Autowired
	private RequirementRepository requirementRepository;
	
	@Autowired
	private UsersServiceClient usersServiceClient;
	
	public Requirement createRequirement(Requirement requirement) {
		requirement.setRequirementState(RequirementState.DRAFT.getStateName());
		//TODO - Find who should be the Task Owner
		String taskOwnerRole = RequirementState.DRAFT.getActor();
		
		//TODO - Use FEIGN Client to find out
		return requirementRepository.save(requirement);
	}

	public List<Requirement> readRequirements() {
		return requirementRepository.findAll();
	}
	
	public Requirement readRequirement(Long id) {
		Optional<Requirement> optionalReq = requirementRepository.findById(id);
		return optionalReq.get();
	}

	public void updateRequirement(Long id, Requirement requirement) {
		requirement.setId(id);
		requirementRepository.save(requirement);
	}
	
	public void promoteRequirement(Long id) {
		Requirement requirement = requirementRepository.findById(id).get();
		RequirementState presentState = RequirementState.getRequirementStateByStateName(requirement.getRequirementState());
		requirement.setRequirementState(presentState.getNextState().getStateName());
		requirementRepository.save(requirement);
	}
	
	public void demoteRequirement(Long id) {
		Requirement requirement = requirementRepository.findById(id).get();
		RequirementState presentState = RequirementState.getRequirementStateByStateName(requirement.getRequirementState());
		requirement.setRequirementState(presentState.getPreviousState().getStateName());
		requirementRepository.save(requirement);
	}

	public void deleteRequirement(Requirement requirement) {
		requirementRepository.delete(requirement);
	}
	
	public void deleteRequirementById(Long id) {
		requirementRepository.deleteById(id);
	}

}
