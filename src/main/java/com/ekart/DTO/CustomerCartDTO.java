package com.ekart.DTO;

import java.util.Set;

import com.ekart.entity.CartProduct;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class CustomerCartDTO {
   
	
	private Integer cartId;
	
	@NotBlank(message = "the email id cannot be null")
	@Email(message = "please provide a valid email")
	private String customerEmailId;
	
	private Set<CartProductDTO> cartProducts;
	
	public Integer getCartId() {
		return cartId;
	}
	
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	
	public String getCustomerEmailId() {
		return customerEmailId;
	}
	
	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}
	
	public Set<CartProductDTO> getCartProducts() {
		return cartProducts;
	}
	
	public void setCartProducts(Set<CartProductDTO> cartProducts) {
		this.cartProducts = cartProducts;
	}
	
	
	
}
