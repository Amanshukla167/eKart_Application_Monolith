package com.ekart.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ekart.DTO.CustomerDTO;
import com.ekart.exception.EKartException;
import com.ekart.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/Customer")
public class CustomerAPI {

	 @Autowired
     private CustomerService customerService;
	
	 
	    @PostMapping(value = "/CreateCustome")
	 	public ResponseEntity<String>registerNewCustomer(@RequestBody @Valid CustomerDTO customerDTO)throws EKartException{
		
	     String msg = customerService.registerNewCustomer(customerDTO);
		
		
		  return new ResponseEntity<String>(msg ,HttpStatus.CREATED);	
	 	}
	
	
}
