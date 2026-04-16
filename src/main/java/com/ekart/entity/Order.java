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
	
	

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public LocalDateTime getDateOfOrder() {
		return dateOfOrder;
	}

	public void setDateOfOrder(LocalDateTime dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getTotalPrise() {
		return totalPrise;
	}

	public void setTotalPrise(Double totalPrise) {
		this.totalPrise = totalPrise;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public PaymentThrough getPaymentThrough() {
		return paymentThrough;
	}

	public void setPaymentThrough(PaymentThrough paymentThrough) {
		this.paymentThrough = paymentThrough;
	}

	public LocalDateTime getDateOfDelivery() {
		return dateOfDelivery;
	}

	public void setDateOfDelivery(LocalDateTime dateOfDelivery) {
		this.dateOfDelivery = dateOfDelivery;
	}

	public List<OrderedProduct> getOrderedProducts() {
		return orderedProducts;
	}

	public void setOrderedProducts(List<OrderedProduct> orderedProducts) {
		this.orderedProducts = orderedProducts;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	
	
}
