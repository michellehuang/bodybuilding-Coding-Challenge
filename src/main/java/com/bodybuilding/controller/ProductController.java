package com.bodybuilding.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bodybuilding.dto.Product;
import com.bodybuilding.dto.ProductForm;
import com.bodybuilding.dto.ProductResponse;
import com.bodybuilding.dto.ProductsForm;
import com.bodybuilding.service.ProductService;
import com.bodybuilding.service.ProductServiceImpl;

@Controller
@RequestMapping(value = "")
public class ProductController {
	
	private ProductServiceImpl productService;
	
	public final static String PRODUCT_VIEW = "product";
	
	@RequestMapping(value = "/getProduct", method = RequestMethod.GET)
	public String getProduct(HttpServletRequest request, Model model) throws Exception {
		ProductsForm form = new ProductsForm();
		
		//web service call for products
		productService = new ProductServiceImpl();
		List<Product> results = productService.getProductInfo();
		
		//set ProductsForm for view
		form = productService.setProductsForm(results);
		
		model.addAttribute("productsForm", form);
		
		return PRODUCT_VIEW;
	}
	
}
