package com.bodybuilding.dto;

import java.util.List;

/**
 * 
 * the product object for view displaying
 *
 */
public class ProductForm {
	//column headers "#", Product Image, Brand, Product Name, Brief Description, Quantity Sold

	private int id;
	private String productImage;
	private String brand;
	private String productName;
	private String description;
	private int quantitySold;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantitySold() {
		return quantitySold;
	}
	public void setQuantitySold(int quantitySold) {
		this.quantitySold = quantitySold;
	}
	
}
