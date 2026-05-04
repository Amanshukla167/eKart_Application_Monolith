package com.ekart.DTO;

import java.util.Objects;

import jakarta.validation.Valid;
import jakarta.validation.constraints.PositiveOrZero;

public class CartProductDTO {
   
	private Integer cartProductId;
	
	@Valid
	private ProductDTO product;
	
	private Integer productID;
	
	
	
	
	@PositiveOrZero(message = "the Quantity can not be in the zero")
	private Integer quantity;

	public Integer getCartProductId() {
		return cartProductId;
	}

	public void setCartProductId(Integer cartProductId) {
		this.cartProductId = cartProductId;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		 if(this == obj) return true;
		 if(obj == null  || this.getClass() != obj.getClass()) return false;
		 
		 CartProductDTO ctdto = (CartProductDTO)obj;
		 
		 if(this.getCartProductId().equals(ctdto.getCartProductId())) {
			 return true;
		 };
		 
		 return false;
		 
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(this.getCartProductId());
	}

	public Integer getProductID() {
		return productID;
	}

	public void setProductID(Integer productID) {
		this.productID = productID;
	}
	
	
}
