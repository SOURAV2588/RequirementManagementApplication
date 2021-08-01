package com.sourav.rma.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.sourav.rma.dto.UserDto;
import com.sourav.rma.entity.User;

public interface UserService extends UserDetailsService {

	User createUser(UserDto userDto);

	User getUser(long id);

	User findUserByUserId(String id);

	List<User> getAllUser();

	User updateUser(long id, User user);

	void deleteUserById(long id);

	void assignProductOwner(String userId);

	void assignBusinessProcessOwner(String userId);

	void assignBusinessAnalyst(String userId);

	void assignDeveloper(String userId);

	void assignQualityAnalyst(String userId);

	void assignDeliveryManager(String userId);

	void assignRequirementOwner(String userId);

}
