/**
 * 
 */
package com.shop.restmongorepository.service;

import java.util.List;

import com.shop.restmongorepository.exception.ConstraintsViolationException;
import com.shop.restmongorepository.exception.DocumentNotFoundException;
import com.shop.restmongorepository.model.Product;

/**
 * @author Arnaud
 *
 */

public interface ProductService {

	List<Product> findAll();
	Product findProductByProductId(String productId)throws DocumentNotFoundException ;
	Product create(Product product) throws ConstraintsViolationException, DocumentNotFoundException;
	Product updateProduct(String productId, Product product) throws ConstraintsViolationException, DocumentNotFoundException;
	void deleteProduct(String productId) throws DocumentNotFoundException;
}
