package com.ekart.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ekart.EkartApplication;
import com.ekart.DTO.ProductDTO;
import com.ekart.exception.EKartException;
import com.ekart.service.CustomerProductService;

@RestController
@RequestMapping(value = "/Products")
public class ProductAPI {
	
	    @Autowired
	    private CustomerProductService customerProductService;
	   
	    
	    @GetMapping(value = "/getAllProducts")
	     public ResponseEntity<List<ProductDTO>>getAllProducts()throws EKartException{
	    	
	    	List<ProductDTO> productList =  customerProductService.getAllProducts();
	    	
	    	return new ResponseEntity<List<ProductDTO>>(productList, HttpStatus.OK);
	    	
	    }
	    
	    
		
	    @GetMapping(value = "/productById/{productId}")
	   public ResponseEntity<ProductDTO>getProductById(@PathVariable Integer productId) throws EKartException{
		   
		   ProductDTO  product = customerProductService.getProductById(productId);
		   
		   return new ResponseEntity<ProductDTO>(product , HttpStatus.OK);
	   }
	    
	    
	    @PutMapping(value = "/updateQuantity/{productId}")
	    public ResponseEntity<String>reduceAvailableQuantity(@PathVariable Integer productId, @RequestBody Integer quantity) throws EKartException{
	    	
	    	    customerProductService.reduceAvailableQuantity(productId, quantity);
	    	    
	    	    String msg = "your quantity has been updated";
	    	    
	    	    return new ResponseEntity<String>(msg, HttpStatus.OK);
	    }

}
