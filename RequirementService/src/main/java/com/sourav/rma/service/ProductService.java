package com.sourav.rma.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourav.rma.dao.ProductRepository;
import com.sourav.rma.entity.Product;
import com.sourav.rma.exception.NoProductOwnerException;
import com.sourav.rma.service.validation.ProductValidator;

/**
 * TODO - Use FEIGN Client to get the User's Details from UserService
 * 		  Set the data accordingly
 * 
 * @author dell
 *
 */
@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Product createProduct(Product product) {
		try {
			ProductValidator.isValidProduct(product);
		} catch (NoProductOwnerException e) {
			e.printStackTrace();
		}
		
		//Find out the users
		String productOwner = product.getProductOwner();
		String businessProcessOwner = product.getBusinessProcessOwner();
		String businessAnalyst = product.getBusinessAnalyst();
		String developer = product.getDeveloper();
		String qualityAnalyst = product.getQualityAnalyst();
		String deliveryManager = product.getDeliveryManager();
		
		//Assign them roles
		
		
		return productRepository.save(product);
	}

	public List<Product> readProducts() {
		return productRepository.findAll();
	}
	
	public Product readProduct(Long id) {
		Optional<Product> optionalReq = productRepository.findById(id);
		return optionalReq.get();
	}
	
	//TODO - Need to implement
	public void getTaskOwnerFromRole(String taskOwnerRole) {
		
	}

	public Product updateProduct(Long id, Product product) {
		product.setId(id);
		return productRepository.save(product);
	}

	public void deleteProduct(Product product) {
		productRepository.delete(product);
	}
	
	public void deleteProductById(Long id) {
		productRepository.deleteById(id);
	}

}
