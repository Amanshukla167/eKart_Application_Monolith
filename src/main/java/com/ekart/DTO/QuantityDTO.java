package com.ekart.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;

public class QuantityDTO {
	
	@NotNull(message = "Quantity cannot be null")
	@Min(value = 1, message = "Quantity must be at least 1")
	private Integer quantity;
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
