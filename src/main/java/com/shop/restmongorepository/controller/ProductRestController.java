/**
 * 
 */
package com.shop.restmongorepository.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.shop.restmongorepository.exception.ConstraintsViolationException;
import com.shop.restmongorepository.exception.DocumentNotFoundException;
import com.shop.restmongorepository.model.Product;
import com.shop.restmongorepository.service.ProductService;

/**
 * @author Arnaud
 *
 */

@RestController
@RequestMapping("products")
public class ProductRestController {

	private final ProductService productService;
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Autowired
	public ProductRestController(final ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/")
	public List<Product> getAllUsers() {
		LOG.info("Getting all products.");
		return productService.findAll();
	}
	
	@GetMapping("/product/{productId}")
	public Product getProductByProductId(@PathVariable String productId) throws DocumentNotFoundException {
		LOG.info("Getting product with ID: {}.", productId);
		return productService.findProductByProductId(productId);
	}
	
	@PostMapping("/product/add")
    @ResponseStatus(HttpStatus.CREATED)
	public Product createProduct(@Valid @RequestBody Product product) throws ConstraintsViolationException, DocumentNotFoundException {
		LOG.info("Saving a new product.");
		return productService.create(product);
	}
	
	@PutMapping("/product/update/{productId}")
	public Product updateProduct(
	        @PathVariable String productId, @Valid @RequestBody Product product)
	        throws DocumentNotFoundException, ConstraintsViolationException {
		
		LOG.info("Updating product with product ID: {}.", productId);
		return productService.updateProduct(productId, product);
	}
	
	@DeleteMapping("/product/delete/{productId}")
	public void deleteProduct(@PathVariable String productId) throws DocumentNotFoundException {
		LOG.info("Deleting product with product ID: {}.", productId);
		productService.deleteProduct(productId);
	}
}
