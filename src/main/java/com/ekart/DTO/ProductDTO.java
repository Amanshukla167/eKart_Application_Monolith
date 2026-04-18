package com.ekart.DTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class ProductDTO {
    
	
	private Integer productId;
	
	private String name;
	
	private String description;
	
	private String category;
	
	private String brand;
	
	private Double price;
	@Max(value = 99 ,message = "the discount can not be more than 100")
	@Min(value = 10 , message = " the discount can not be less tha 10")
	private Double discount;
	
	@Size(min = 3 , max = 10 , message = "PLease enter minimum 3 and mamximum 10")
	private Integer quantity;
	
	private String errorMessage;
	
	private String successMessage;
	
	private String sellerEmailId;
	
	private Integer availableQuantity;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

	public String getSellerEmailId() {
		return sellerEmailId;
	}

	public void setSellerEmailId(String sellerEmailId) {
		this.sellerEmailId = sellerEmailId;
	}

	public Integer getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	
	
	
}
