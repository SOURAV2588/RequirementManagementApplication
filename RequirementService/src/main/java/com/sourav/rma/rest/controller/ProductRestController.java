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

import com.sourav.rma.entity.Product;
import com.sourav.rma.entity.Requirement;
import com.sourav.rma.service.ProductService;
import com.sourav.rma.service.RequirementService;

@RestController
@RequestMapping("/products")
public class ProductRestController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private RequirementService requirementService;

	@Autowired
	private Environment env;

	@GetMapping("/status-check")
	public String statusCheck() {
		return "Working on port : " + env.getProperty("server.port");
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Product createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> readProducts() {
		return productService.readProducts();
	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Product readProduct(@PathVariable long id) {
		return productService.readProduct(id);
	}

	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Product updateProduct(@PathVariable long id, @RequestBody Product product) {
		return productService.updateProduct(id, product);
	}

	@DeleteMapping(path = "/{id}")
	public void deleteProduct(@PathVariable long id) {
		productService.deleteProductById(id);
	}

	@PostMapping(path = "/{productId}/requirements",
				consumes = MediaType.APPLICATION_JSON_VALUE, 
				produces = MediaType.APPLICATION_JSON_VALUE)
	public Requirement createRequirement(@PathVariable("productId") long productId, @RequestBody Requirement requirement) {
		Product product = productService.readProduct(productId);
		requirement.setProduct(product);
		return requirementService.createRequirement(requirement);
	}

	@GetMapping(path = "/{productId}/requirements",
				produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Requirement> readRequirements(@PathVariable("productId") long productId) {
		Product product = productService.readProduct(productId);
		return product.getRequirements();
	}

	@GetMapping(path = "/{productId}/requirements/{id}",
				produces = MediaType.APPLICATION_JSON_VALUE)
	public Requirement readRequirement(@PathVariable("id") Long id) {
		return requirementService.readRequirement(id);
	}

	@PutMapping(path = "/{productId}/requirements/{id}",
				consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateRequirement(@PathVariable("id") Long id, @RequestBody Requirement requirement) {
		requirementService.updateRequirement(id, requirement);
	}

	@DeleteMapping("/{productId}/requirements/{id}")
	public void deleteRequirement(@PathVariable("id") Long id) {
		requirementService.deleteRequirementById(id);
	}

}
