package com.bodybuilding.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.bodybuilding.dto.Product;
import com.bodybuilding.dto.ProductResponse;
import com.bodybuilding.dto.ProductsForm;

/**
 * 
 * interface for services
 *
 */
public interface ProductService {
	public List<Product> getProductInfo() throws Exception;
	public ProductsForm setProductsForm(List<Product> productDaos) throws Exception;
}
