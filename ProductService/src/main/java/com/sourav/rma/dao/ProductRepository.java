package com.sourav.rma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sourav.rma.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

	@Query(nativeQuery = true, value="SELECT PRODUCT_ID FROM PRODUCT ORDER BY PRODUCT_ID DESC LIMIT 1")
	public String getLastProductId();
	
	@Override
	public List<Product> findAll();
	
}
