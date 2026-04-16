package com.ekart.DTO;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDTO {
    
	private Integer orderId;
	
	private String customerEmailId;
	
	private LocalDateTime dateOfOrder;
	
	private Double totalPrice;
	
	private String orderStatus;
	
	private Double discount;
	
	private String paymentThrough;
	
	private LocalDateTime dateOfDelivery;
	
	private String deliveryAddress;
	
	private List<OrderedProductDTO> orderedProducts;
	
}
