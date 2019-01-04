/**
 * 
 */
package com.shop.restmongorepository.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Arnaud
 *
 */

@Document
public class Product {

	@Id
	private String productId;
	private String name;
	private BigDecimal unitPrice;
	private String description;
	private Long unitsInStock;
	private Map<String, String> productSettings = new HashMap<>();
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getUnitsInStock() {
		return unitsInStock;
	}
	public void setUnitsInStock(Long unitsInStock) {
		this.unitsInStock = unitsInStock;
	}
	public Map<String, String> getProductSettings() {
		return productSettings;
	}
	public void setProductSettings(Map<String, String> productSettings) {
		this.productSettings = productSettings;
	}	
}
