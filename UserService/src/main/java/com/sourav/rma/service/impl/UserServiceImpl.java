package com.sourav.rma.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sourav.rma.dao.RoleRepository;
import com.sourav.rma.dao.UserRepository;
import com.sourav.rma.dto.UserDto;
import com.sourav.rma.entity.ActorPrivileges;
import com.sourav.rma.entity.Role;
import com.sourav.rma.entity.User;
import com.sourav.rma.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public User createUser(UserDto userDto) {
		User user = new User();
		user.setUserId(userDto.getUserId());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		String encryptedPassword = bCryptPasswordEncoder.encode(userDto.getPassword());
		user.setEncryptedPassword(encryptedPassword);
		return userRepository.save(user);
	}
	
	public User getUser(long id) {
		Optional<User> user= userRepository.findById(id);
		return user.get();
	}
	
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	
	public User updateUser(long id, User user) {
		Optional<User> designatedUserOptional = userRepository.findById(id);
		User designatedUser = designatedUserOptional.get();
		designatedUser.setFirstName(user.getFirstName());
		designatedUser.setLastName(user.getLastName());
		designatedUser.setEmail(user.getEmail());
//		TODO - Should be a restricted method
		//designatedUser.setPassword(user.getPassword());
		return userRepository.save(designatedUser);
	}
	
	public void deleteUser(User user) {
		userRepository.delete(user);
	}
	
	public void deleteUserById(long id) {
		userRepository.delete(userRepository.findById(id).get());
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Username passed : " + username);
		User user = userRepository.findByUserId(username);
		
		 if(user == null) {
			 throw new UsernameNotFoundException(username);
		 }
		 
		return new org.springframework.security.core.userdetails.User(user.getUserId(), 
				user.getEncryptedPassword(),
				true,
				true,
				true,
				true,
				new ArrayList<>());
	}

	@Override
	public User findUserByUserId(String userId) {
		return userRepository.findByUserId(userId);
	}
	
	@Override
	public void assignProductOwner(String userId) {
		assignRole(userId, ActorPrivileges.PRODUCT_OWNER);
	}

	@Override
	public void assignBusinessProcessOwner(String userId) {
		 assignRole(userId, ActorPrivileges.BUSINESS_PROCESS_OWNER);
	}

	@Override
	public void assignBusinessAnalyst(String userId) {
		assignRole(userId, ActorPrivileges.BUSINESS_ANALYST);
	}

	@Override
	public void assignDeveloper(String userId) {
		assignRole(userId, ActorPrivileges.DEVELOPER);
	}

	@Override
	public void assignQualityAnalyst(String userId) {
		assignRole(userId, ActorPrivileges.QUALITY_ANALYST);
	}

	@Override
	public void assignDeliveryManager(String userId) {
		assignRole(userId, ActorPrivileges.DELIVERY_MANAGER);
	}

	@Override
	public void assignRequirementOwner(String userId) {
		assignRole(userId, ActorPrivileges.REQUIREMENT_OWNER);
	}
	
	private void assignRole(String userId, ActorPrivileges privilege) {
		User user = userRepository.findByUserId(userId);
		List<Role> roles = (List<Role>) user.getRoles();
		Role newRole = roleRepository.findByName(privilege.name());
		if(newRole == null) {
			newRole = new Role();
			newRole.setName(privilege.name());
			roleRepository.save(newRole);
		}
		roles.add(newRole);
		user.setRoles(roles);
		userRepository.save(user);
	}

}
