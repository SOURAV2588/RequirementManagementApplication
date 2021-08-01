package com.sourav.rma.controller;

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

import com.sourav.rma.entity.Product;
import com.sourav.rma.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductRestController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private Environment env; 
	
	@GetMapping("/status-check")
	public String statusCheck() {
		return "Working on port : " + env.getProperty("server.port");
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
				 produces = MediaType.APPLICATION_JSON_VALUE)
	public Product createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> readProducts() {
		return productService.readProducts();
	}
	
	@GetMapping(path = "/{id}", 
				produces = MediaType.APPLICATION_JSON_VALUE)
	public Product readProduct(@PathVariable long id) {
		return productService.readProduct(id);
	}
	
	@PutMapping(path = "/{id}", 
				consumes = MediaType.APPLICATION_JSON_VALUE,
			    produces = MediaType.APPLICATION_JSON_VALUE)
	public Product updateProduct(@PathVariable long id, @RequestBody Product product) {
		return productService.updateProduct(id, product);
	}
	
	@DeleteMapping(path = "/{id}")
	public void deleteProduct(@PathVariable long id) {
		productService.deleteProductById(id);
	}

}
