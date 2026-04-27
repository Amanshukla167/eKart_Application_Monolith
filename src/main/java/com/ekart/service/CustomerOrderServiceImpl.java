package com.ekart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekart.DTO.CustomerDTO;
import com.ekart.DTO.OrderDTO;
import com.ekart.DTO.OrderedProductDTO;
import com.ekart.DTO.ProductDTO;
import com.ekart.Enum.OrderStatus;
import com.ekart.Enum.PaymentThrough;
import com.ekart.entity.Order;
import com.ekart.entity.OrderedProduct;
import com.ekart.entity.Product;
import com.ekart.exception.EKartException;
import com.ekart.repo.CustomerOrderRepository;
import com.ekart.repo.CustomerOrderedProduct;
import com.ekart.repo.ProductRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class CustomerOrderServiceImpl implements CustomerOrderService {
             
	        @Autowired
			private CustomerOrderRepository customerOrderRepository;
			
	        @Autowired
	        private CustomerService customerService;
	        
	        @Autowired
	        private ProductRepository productRepository;
	        
	        
	        @Autowired
	        private CustomerOrderedProduct customerOrderedProduct;
			
			
			@Override
			public Integer placeOrder(OrderDTO orderDTO) throws EKartException {
				
				Integer orderID = null;
				Double totalPrice = 0.0;
				Double loopPrise = 0.0;
         	    Double FinaltotalPrice = 0.0;	
			
					List<OrderedProduct> orderedProducts = new ArrayList<OrderedProduct>();
					CustomerDTO customerDTO = customerService.getCustomerByEmailId(orderDTO.getCustomerEmailId());
	
					
						
						List<OrderedProductDTO>	orderedProductDTO = orderDTO.getOrderedProducts();
						 
						Order orderEntity = new Order();
	
						orderEntity.setDeliveryAddress(orderDTO.getDeliveryAddress());
						orderEntity.setDateOfDelivery(orderDTO.getDateOfDelivery());
						orderEntity.setDateOfOrder(orderDTO.getDateOfOrder());
						orderEntity.setOrderStatus(OrderStatus.valueOf(orderDTO.getOrderStatus().toUpperCase()));
						orderEntity.setPaymentThrough(PaymentThrough.valueOf(orderDTO.getPaymentThrough().toUpperCase()));
//						orderEntity.setDiscount(orderDTO.getDiscount());
						
						for(OrderedProductDTO dto : orderedProductDTO) {
							if(dto != null) {
								   OrderedProduct orderedProduct = new OrderedProduct();
									orderedProduct.setOrderedProductId(dto.getOrderedProductId());
									
					     	        Optional<Product>foundProduct = productRepository.findById(dto.getProduct().getProductId());
					     	        
									   Product product = foundProduct.orElseThrow(()-> new EKartException("product not found please use the diffrent product"));
									  
									 
									   orderedProduct.setProductId(product.getProducstId());
									   
					                   if(  dto.getQuantity() <= product.getAvailableQuantity()) {
					                	   orderedProduct.setQuantity(dto.getQuantity());
					                	   product.setAvailableQuantity(product.getAvailableQuantity() - dto.getQuantity());
					                	   
					                   }else {
					                	   throw new EKartException("the Require quanttiy of product is not avalilble");
					                   }
					            
					           	     Integer quant = dto.getQuantity();				          
					           		 totalPrice = (quant * product.getPrice());
					           		loopPrise+=totalPrice;
					           		   
								 	orderedProducts.add(orderedProduct);
								
							}
							
						}
						
						Double discount = orderDTO.getDiscount().doubleValue();
						
						FinaltotalPrice =loopPrise - (loopPrise*( discount/100));
						 
						orderEntity.setOrderedProducts(orderedProducts);
						orderEntity.setTotalPrise(FinaltotalPrice);
						
					   
					Order order = customerOrderRepository.save(orderEntity);
					orderID = order.getOrderId();	
	 				
				  
				return orderID ;
			}
			
			
			@Override
			public OrderDTO getOrderDetails(Integer orderId) throws EKartException {
				
				
				  Optional<Order> orderObj = customerOrderRepository.findById(orderId);
				  
			      Order order = orderObj.orElseThrow(()-> new EKartException("this Order is not avalible, please try again"));
			      
			      OrderDTO dto = new OrderDTO();
			      
			      dto.setOrderId(order.getOrderId());
			      dto.setOrderStatus(order.getOrderStatus().toString().toUpperCase());
			      dto.setCustomerEmailId(order.getCustomerEmaiId());
			      dto.setDateOfOrder(order.getDateOfOrder());
			      dto.setDateOfDelivery(order.getDateOfDelivery());
			      dto.setDeliveryAddress(order.getDeliveryAddress());
			      dto.setTotalPrice(order.getTotalPrise());
			      dto.setPaymentThrough(order.getPaymentThrough().toString().toUpperCase());
			      
			      
			      List<OrderedProduct> orderList = order.getOrderedProducts();
			      
			      if(orderList.isEmpty()) {
			    	  throw new EKartException("there is no order histroy avalilbel in the orderted Itme");
			    	  
			      }
			      
			     
			      List<OrderedProductDTO> orderedProductDTOList = new ArrayList<OrderedProductDTO>();
			      for( OrderedProduct orderedProduct : orderList) {
			    	
			    	
			    	  OrderedProductDTO orderedProductDTO = new OrderedProductDTO();
			    	  
			    	  orderedProductDTO.setQuantity(orderedProduct.getQuantity());
			    	  orderedProductDTO.setOrderedProductId(orderedProduct.getOrderedProductId());
			    	  
			    	  Optional<Product>foundProduct = productRepository.findById(orderedProduct.getProductId());
		     	        
					   Product product = foundProduct.orElseThrow(()-> new EKartException("product not found please use the diffrent product"));
					    
					   ProductDTO productDTO = new ProductDTO();
					   
					   productDTO.setName(product.getName());
					   productDTO.setBrand(product.getBrand());
					   productDTO.setCategory(product.getCategory());
					   productDTO.setDescription(product.getDescription());
					   productDTO.setPrice(product.getPrice());
					   
			    	  
			    	  
			    	  orderedProductDTO.setProduct(productDTO);
					   
			    	  orderedProductDTOList.add(orderedProductDTO);
					  
			      }
			      
			      dto.setOrderedProducts(orderedProductDTOList);
			      
				    
				return dto;
			}
			
			
			@Override
			public List<OrderDTO> findOrdersByCustomerEmailId(String emailId) throws EKartException {
			    
		         List<Order> orderObj = customerOrderRepository.findByCustomerEmaiId(emailId);
		         
		         if(orderObj.isEmpty() || orderObj == null) {
		        	 throw new EKartException("costomer does not exist");
		         }
		         
		         List<OrderDTO> orderDTOList = new ArrayList<OrderDTO>();
		         
		         for(Order order : orderObj) {
			        	
		        	 OrderDTO orderDTO = new OrderDTO();
		        	 
		        	 orderDTO.setOrderId(order.getOrderId());
		        	 orderDTO.setOrderStatus(order.getOrderStatus().toString().toUpperCase());
		        	 orderDTO.setCustomerEmailId(order.getCustomerEmaiId());
		        	 orderDTO.setDateOfOrder(order.getDateOfOrder());
		        	 orderDTO.setDateOfDelivery(order.getDateOfDelivery());
		        	 orderDTO.setDeliveryAddress(order.getDeliveryAddress());
		        	 orderDTO.setTotalPrice(order.getTotalPrise());
		        	 orderDTO.setPaymentThrough(order.getPaymentThrough().toString().toUpperCase());
				      
				      
				      List<OrderedProduct> orderList = order.getOrderedProducts();
				      
				      if( orderList == null || orderList.isEmpty() ) {
				    	  throw new EKartException("there is no order histroy avalilbel in the orderted Itme");
				    	  
				      }
				      
				     
				      List<OrderedProductDTO> orderedProductDTOList = new ArrayList<OrderedProductDTO>();
				      for( OrderedProduct orderedProduct : orderList) {
				    	
				    	
				    	  OrderedProductDTO orderedProductDTO = new OrderedProductDTO();
				    	  
				    	  orderedProductDTO.setQuantity(orderedProduct.getQuantity());
				    	  orderedProductDTO.setOrderedProductId(orderedProduct.getOrderedProductId());
				    	  
				    	  Optional<Product>foundProduct = productRepository.findById(orderedProduct.getProductId());
			     	        
						   Product product = foundProduct.orElseThrow(()-> new EKartException("product not found please use the diffrent product"));
						    
						   
						
						   
						   ProductDTO productDTO = new ProductDTO();
						   
						   productDTO.setName(product.getName());
						   productDTO.setBrand(product.getBrand());
						   productDTO.setCategory(product.getCategory());
						   productDTO.setDescription(product.getDescription());
						   productDTO.setPrice(product.getPrice());
						   
				    	  
				    	  
				    	  orderedProductDTO.setProduct(productDTO);
						   
				    	  orderedProductDTOList.add(orderedProductDTO);
						  
				      }
				      
				      orderDTO.setOrderedProducts(orderedProductDTOList);
				      
				      orderDTOList.add(orderDTO);
			        	
			        }
		          
				
				return orderDTOList;
			}
			
			
			@Override
			public void updateOrderStatus(Integer orderId, OrderStatus orderStatus) throws EKartException {
		
				
                  Optional<Order> orderObj = customerOrderRepository.findById(orderId);
				  
			      Order order = orderObj.orElseThrow(()-> new EKartException("this Order is not avalible, please try again"));
			      
			      order.setOrderStatus(orderStatus);
			      
			      customerOrderRepository.save(order);
				
				
			}
			
			@Override
			public void updatePaymentThrough(Integer orderId, PaymentThrough paymentThrough) throws EKartException {
				
				 Optional<Order> orderObj = customerOrderRepository.findById(orderId);
				  
			      Order order = orderObj.orElseThrow(()-> new EKartException("this Order is not avalible, please try again"));
			      
			      order.setPaymentThrough(paymentThrough); 
			      
			      customerOrderRepository.save(order);
				
			}
	
}
