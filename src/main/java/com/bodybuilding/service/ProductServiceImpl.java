package com.bodybuilding.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bodybuilding.client.ProductRestTemplate;
import com.bodybuilding.dto.Product;
import com.bodybuilding.dto.ProductForm;
import com.bodybuilding.dto.ProductResponse;
import com.bodybuilding.dto.ProductsForm;

/**
 * 
 * implementation of service
 *
 */
@Service
public class ProductServiceImpl implements ProductService {
	
    private ProductRestTemplate productRestTemplate;

	@Override
	public List<Product> getProductInfo()
			throws Exception {
		ProductResponse productResponse = new ProductResponse();
		List<Product> products = new ArrayList<Product>();
		
		productRestTemplate = new ProductRestTemplate();
		
		// build the URI
		final String path = "/api-proxy/commerce/products";
		
		// web service call to get product info
		final ResponseEntity<ProductResponse> results = productRestTemplate.getForEntity(path, ProductResponse.class);
		
		if (results.getStatusCode() == HttpStatus.NOT_FOUND || results.getBody() == null) {
			throw new Exception();
		}
		
		productResponse = results.getBody();
		
		return products;
	}

	@Override
	public ProductsForm setProductsForm(List<Product> productDaos) 
			throws Exception {
		ProductsForm productsForm = new ProductsForm();
		List<ProductForm> products = new ArrayList<ProductForm>();
		
		if(!productDaos.isEmpty()) {
			for(Product p : productDaos) {
				ProductForm product = new ProductForm();
				product.setBrand(p.getBrandId());
				product.setDescription(p.getDescription());
				product.setId(productDaos.indexOf(p)+1);
				product.setProductImage("http://store.bbcomcdn.com" + p.getWhite70PxImgUrl());
				product.setProductName(p.getName());
				product.setQuantitySold(p.getNumberSoldInLast30Days());
				
				products.add(product);
			}
			
			productsForm.setProducts(products);
		}
		
		return productsForm;
	}
}
