package com.sourav.rma.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourav.rma.dao.ProductRepository;
import com.sourav.rma.entity.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	public List<Product> readProducts() {
		return productRepository.findAll();
	}
	
	public Product readProduct(Long id) {
		Optional<Product> optionalReq = productRepository.findById(id);
		return optionalReq.get();
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
