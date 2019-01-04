/**
 * 
 */
package com.shop.restmongorepository.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.restmongorepository.exception.ConstraintsViolationException;
import com.shop.restmongorepository.exception.DocumentNotFoundException;
import com.shop.restmongorepository.model.Product;
import com.shop.restmongorepository.repository.ProductRepository;

/**
 * @author Arnaud
 *
 */

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;
	
	public ProductServiceImpl(final ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	private Product findProductChecked(String productId) throws DocumentNotFoundException {
		return productRepository.findById(productId)
				.orElseThrow(() -> new DocumentNotFoundException("Could not find document with the id: " + productId));
	}
	
	/* (non-Javadoc)
	 * @see com.shop.restmongorepository.service.ProductService#findAll()
	 */
	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product findProductByProductId(String productId) throws DocumentNotFoundException {
		// TODO Auto-generated method stub
		return findProductChecked(productId);
	}

	@Override
	public Product create(Product product) throws ConstraintsViolationException, DocumentNotFoundException {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(String productId, Product product)
			throws ConstraintsViolationException, DocumentNotFoundException {
		// TODO Auto-generated method stub
		Product productToBeUpdated = findProductChecked(productId);
		if (productToBeUpdated != null) {
			productToBeUpdated.setName(product.getName());
			productToBeUpdated.setUnitPrice(product.getUnitPrice());
			productToBeUpdated.setDescription(product.getDescription());
			productToBeUpdated.setUnitsInStock(product.getUnitsInStock());
		}
		return productRepository.save(productToBeUpdated);
	}

	@Override
	public void deleteProduct(String productId) throws DocumentNotFoundException {
		// TODO Auto-generated method stub
		Product productToBeDeleted = findProductChecked(productId);
		productRepository.delete(productToBeDeleted);
	}
}
