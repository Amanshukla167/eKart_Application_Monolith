package com.ekart.DTO;

import java.util.Objects;

public class CartProductDTO {
   
	private Integer cartProductId;
	
	private ProductDTO product;
	
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
		 
		 if(this.getCartProductId() == ctdto.getCartProductId()) {
			 return true;
		 };
		 
		 return false;
		 
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(this.getCartProductId());
	}
	
	
}
