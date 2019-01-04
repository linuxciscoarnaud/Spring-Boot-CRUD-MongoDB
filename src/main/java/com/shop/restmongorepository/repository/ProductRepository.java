/**
 * 
 */
package com.shop.restmongorepository.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.shop.restmongorepository.model.Product;

/**
 * @author Arnaud
 *
 */

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
	
}
