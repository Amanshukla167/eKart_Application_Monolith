package com.ekart.service;

import java.util.List;

import com.ekart.DTO.OrderDTO;
import com.ekart.Enum.OrderStatus;
import com.ekart.Enum.PaymentThrough;
import com.ekart.exception.EKartException;

public interface CustomerOrderService {

	Integer placeOrder(OrderDTO orderDTO) throws EKartException;
	
	OrderDTO getOrderDetails(Integer orderId) throws EKartException;
	
	List<OrderDTO> findOrdersByCustomerEmailId(String emailId) throws EKartException;

	void updateOrderStatus(Integer orderId, OrderStatus orderStatus) throws EKartException;

	void updatePaymentThrough(Integer orderId, PaymentThrough paymentThrough) throws EKartException;
}
