package com.ekart.api;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ekart.DTO.CartProductDTO;
import com.ekart.DTO.CustomerCartDTO;
import com.ekart.exception.EKartException;
import com.ekart.service.CustomerCartServiceImpl;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/cart-api")
public class CartAPI {

	
		@Autowired
		private CustomerCartServiceImpl cartServiceImpl;
		
		@PostMapping(value = "/addProductCart")
		ResponseEntity<String>addProductToCart(@Valid @RequestBody CustomerCartDTO cartDTO) throws EKartException{
			
	     	Integer custId  = cartServiceImpl.addProductToCart(cartDTO);
			
			
			String msg = "product added to the cart successfulyy , Your cart Id is : " + custId;
			return new ResponseEntity<String>(msg , HttpStatus.OK);
		}
		
		@GetMapping(value = "/product/{customerEmailId}")
		ResponseEntity<Set<CartProductDTO>>getProductsFromCart(@PathVariable String customerEmailId)throws EKartException{
			
		    Set<CartProductDTO> cartprodut = cartServiceImpl.getProductsFromCart(customerEmailId);
		    
			return new ResponseEntity<Set<CartProductDTO>>(cartprodut , HttpStatus.OK);
		}
		
		@PutMapping(value = "cart/{customerEmailId}/product/{productId}")
		public ResponseEntity<String>modifyQuantityOfProductInCart ( @PathVariable String customerEmailId,
				 @NotNull  @PathVariable Integer productId, @RequestBody Integer quantity)throws EKartException{
			
			cartServiceImpl.modifyQuantityOfProductInCart(customerEmailId, productId, quantity);
			
			String msg = "you item has been modified of the Product Id : " + productId ;
			
			return new ResponseEntity<String>(msg , HttpStatus.OK);
		}
		
}
