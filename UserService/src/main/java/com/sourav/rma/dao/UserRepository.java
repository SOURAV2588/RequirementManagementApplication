package com.sourav.rma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sourav.rma.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	List<User> findAll();

	User findByUserId(String userId);

}
