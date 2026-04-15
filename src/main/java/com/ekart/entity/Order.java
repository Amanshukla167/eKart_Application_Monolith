package com.ekart.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.ekart.Enum.OrderStatus;
import com.ekart.Enum.PaymentThrough;

public class Order {

	
	
	private Integer orderId;
	
	private LocalDateTime dateOfOrder;
	
	private Double discount;
	
	private Double totalPrise;
	
	private OrderStatus orderStatus;
	
	private PaymentThrough paymentThrough;
	
	private LocalDateTime dateOfDelivery;
	
	private List<OrderedProduct> orderedProducts;
	
	private String deliveryAddress;
	
	
}
