/**
 * 
 */
package com.sourav.rma.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sourav.rma.entity.Requirement;
import com.sourav.rma.service.RequirementService;

/**
 * @author Sourav Ghosh
 *
 */
@RestController
@RequestMapping("/requirements")
public class RequirementRestController {
	
	@Autowired
	private RequirementService requirementService;
	
	@Autowired
	private Environment env; 
	
	@GetMapping("/status")
	public String statusCheck() {
		return "Working on port : " + env.getProperty("server.port");
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
				 produces = MediaType.APPLICATION_JSON_VALUE)
	public Requirement createRequirement(@RequestBody Requirement requirement) {
		return requirementService.createRequirement(requirement);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Requirement> readRequirements() {
		return requirementService.readRequirements();
	}
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Requirement readRequirement(@PathVariable("id") Long id) {
		return requirementService.readRequirement(id);
	}

	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateRequirement(@PathVariable("id") Long id,
								  @RequestBody Requirement requirement) {
		requirementService.updateRequirement(id, requirement);
	}
	
	@PutMapping(path = "/{id}/promote")
	public void promoteRequirement(@PathVariable("id") Long id) {
		requirementService.promoteRequirement(id);
	}
	
	@PutMapping(path = "/{id}/demote")
	public void demoteRequirement(@PathVariable("id") Long id) {
		requirementService.demoteRequirement(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteRequirement(@PathVariable("id") Long id) {
		requirementService.deleteRequirementById(id);
	}

}
