package com.ekart.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ekart.DTO.CustomerDTO;
import com.ekart.exception.EKartException;
import com.ekart.service.CustomerService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;

@RestController
@RequestMapping(value = "/Customer")
public class CustomerAPI {

	 @Autowired
     private CustomerService customerService;
	
	     
	    @GetMapping(value = "/authicateCustomer/{emailId}/{password}")
	    public ResponseEntity<CustomerDTO>authicateCustomer(@PathVariable @Email String emailId, @PathVariable String password) throws EKartException{
	    	
	        CustomerDTO customerDTO = customerService.authenticateCustomer(emailId, password);
	    
	         return new ResponseEntity<CustomerDTO>(customerDTO,HttpStatus.ACCEPTED);
	    }
	 
	 
	    @PostMapping(value = "/CreateCustome")
	 	public ResponseEntity<String>registerNewCustomer(@RequestBody @Valid CustomerDTO customerDTO)throws EKartException{
		
	      String msg = customerService.registerNewCustomer(customerDTO);
		
		
		  return new ResponseEntity<String>(msg ,HttpStatus.CREATED);	
	 	}
	    
	    
	    
	    @PutMapping(value = "/updateAddress/{customerEmailId}")
	    public ResponseEntity<String>updateShippingAddress(@PathVariable @Email String customerEmailId, @RequestBody String address)throws EKartException{
	    	
	    	customerService.updateShippingAddress(customerEmailId, address);
	    	
	    	String  msg= "your address updated successfulyy!!!!"; 
	    	
	    	return new ResponseEntity<String>(msg , HttpStatus.ACCEPTED);
	    }
	    
	    
	    @DeleteMapping(value = "/deleteAddress/{customerEmailId}")
	    public ResponseEntity<String>deleteShippingAddress(@Email @PathVariable String customerEmailId)throws EKartException{
	    	
	    	customerService.deleteShippingAddress(customerEmailId);
	    	
	    	String msg = "your shipping address deleted succesfullyy !!";
	    	
	    	return new ResponseEntity<String>(msg , HttpStatus.OK);
	    }
	    
	    
	    @GetMapping(value = "/getCustomerFetails/{emailId}")
	    public ResponseEntity<CustomerDTO>getCustomer(@PathVariable String emailId) throws EKartException{
	    	
	       CustomerDTO customerDTO = customerService.getCustomerByEmailId(emailId);
	       
	       return new ResponseEntity<CustomerDTO>(customerDTO , HttpStatus.OK);
	    }
	
	
}
