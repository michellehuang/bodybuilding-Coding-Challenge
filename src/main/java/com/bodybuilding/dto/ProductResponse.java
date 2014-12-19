package com.bodybuilding.dto;

import java.io.Serializable;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 
 * Wrapper object to snuggle with names so that it is a RESTful JSON response.
 *
 */
@JsonSerialize
public class ProductResponse implements Serializable {

	@JsonIgnore
	private static final long serialVersionUID = 5613117165530240861L;
	
	@JsonProperty
	private List<Product> products;
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public ProductResponse() {
		
	}
	
	public ProductResponse(List<Product> products) {
		this.products = products;
	}


}
