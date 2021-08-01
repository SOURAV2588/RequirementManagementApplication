/**
 * 
 */
package com.sourav.rma.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.sourav.rma.model.RoleModel;
import com.sourav.rma.model.UserModel;

/**
 * @author dell
 *
 */
@FeignClient(name = "user-ws")
public interface UsersServiceClient {
	
	@GetMapping("/users/{id}")
	public UserModel getUser(@PathVariable String id);
	
	@PutMapping("/users/{id}/assignrole")
	public UserModel assignRole(@PathVariable String id, RoleModel role);

}
