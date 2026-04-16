package com.ekart.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "ek_cart_product")
public class CartProduct {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartProductId;

	private Integer productId;
	
	private Integer quantity;
	
	public Integer getCartProductId() {
		return cartProductId;
	}
	
	public void setCartProductId(Integer cartProductId) {
		this.cartProductId = cartProductId;
	}
	
	public Integer getProductId() {
		return productId;
	}
	
	public void setProductId(Integer productId) {
		this.productId = productId;
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
//		return super.equals(obj);
		
		if(this == obj) return true;
		
		if(obj == null || this.getClass()!= obj.getClass())return false;
		
		CartProduct otherobj = (CartProduct)obj;
		
		if(this.getProductId() == otherobj.getProductId()) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hashCode(this.getProductId());
	}
	
	
}


