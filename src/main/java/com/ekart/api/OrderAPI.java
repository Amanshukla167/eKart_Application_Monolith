package com.ekart.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ekart.DTO.OrderDTO;
import com.ekart.Enum.OrderStatus;
import com.ekart.Enum.PaymentThrough;
import com.ekart.exception.EKartException;
import com.ekart.service.CustomerOrderService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;

@RestController
@RequestMapping(value =  "/Order")
public class OrderAPI {
		
	
	 @Autowired
	 private CustomerOrderService customerOrderService;
	 
	 
	 @PostMapping(value = "/placeOrder")
	 public ResponseEntity<String>Plaaceoder( @RequestBody @Valid OrderDTO orderDTO)throws EKartException{
		 
	      Integer orderId = customerOrderService.placeOrder(orderDTO);
		 
	      String msg = " your order has been placed and your orderId is : " + orderId;
		 
		 return new ResponseEntity<String>(msg , HttpStatus.CREATED);
	 }
	 
	 
	 @GetMapping(value =  "/orderDetail/{orderId}")
	 public ResponseEntity<OrderDTO>getOrderDetails( @PathVariable Integer orderId) throws EKartException{
		 
		OrderDTO orderDTO =  customerOrderService.getOrderDetails(orderId);
		
		return new ResponseEntity<OrderDTO>(orderDTO , HttpStatus.OK);
		 
	 }
	 
	 
	 @GetMapping(value =  "/getOrderHistory/{emailId}")
	 public ResponseEntity<List<OrderDTO>>findOrdersByCustomerEmailId( @PathVariable  @Email String emailId) throws EKartException{
		 
         	List<OrderDTO> order = customerOrderService.findOrdersByCustomerEmailId(emailId);
		 
         	return new ResponseEntity<List<OrderDTO>>(order, HttpStatus.OK);
	 }
	 
	 
	 
	 @PutMapping(value = "/orderStatusUpdate/{orderId}")
	 public ResponseEntity<String>updateOrderStatus( @PathVariable Integer orderId, @RequestBody OrderStatus orderStatus) 
			 throws EKartException{
		 
		    customerOrderService.updateOrderStatus(orderId, orderStatus);
		    
		    String msg = " your order has been succesfully updated";
		    
		    return new ResponseEntity<String>(msg , HttpStatus.OK);
		 
	 }
	 
	 public ResponseEntity<String>updatePaymentThrough(@PathVariable Integer orderId, @RequestBody PaymentThrough paymentThrough) 
			 throws EKartException {
		 
		    customerOrderService.updatePaymentThrough(orderId, paymentThrough);
		    
		    
		    String msg = "your payment methos has been updated successfully";
		    
		    return new ResponseEntity<String>(msg, HttpStatus.OK);
	 }
		
		
}
