package com.ekart.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ekart.DTO.CustomerDTO;
import com.ekart.entity.Customer;
import com.ekart.exception.EKartException;
import com.ekart.repo.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    
	    @Autowired
	    private CustomerRepository customerRepository;
	
		@Override
		public CustomerDTO authenticateCustomer(String emailId, String password) throws EKartException {
		// TODO Auto-generated method stub
		return null;
		}
		
		
	  
	  	@Override
	  	public String registerNewCustomer(CustomerDTO customerDTO) throws EKartException {
	  		
	  	     Optional<Customer> foundId = customerRepository.findById(customerDTO.getEmailId()); 
	  	     
	  	     String msg = null;
	  	     
	  	    if(foundId.isEmpty()) {
	  	    	Customer cust = new Customer();
	  	    	
	  	    	cust.setEmailId(customerDTO.getEmailId());
	  	    	cust.setName(customerDTO.getName());
	  	    	cust.setPassword(customerDTO.getPassword());
	  	    	cust.setPhoneNumber(customerDTO.getPhoneNumber());
	  	    	cust.setAddress(customerDTO.getAddress());
	  	    	
	  	    	customerRepository.save(cust);
	  	    	
	  	    	msg = "you registration has been successfully completed. you email ID is  : " + cust.getEmailId();
	  	    	
	  	    }else {
	  	    	
	  	    	throw new EKartException("the customer Email id is alreadr exist, plesae try with diffrent ID");
	  	    	
	  	    	
	  	    }
	  	     
	  		return msg;
	  	}
	  	
	  	
	  	@Override
	  	public void updateShippingAddress(String customerEmailId, String address) throws EKartException {
	  	    
	    	Optional<Customer> foundID = customerRepository.findById(customerEmailId);
	    	
	       Customer custobj = foundID.orElseThrow(() -> new EKartException("the User don't have any account from this email id"));
	       
	       
	        	custobj.setAddress(address);
	        
	        
	        customerRepository.save(custobj);
	  	
	  	}
	  	
	  	
	  	@Override
	  	public void deleteShippingAddress(String customerEmailId) throws EKartException {
	  	// TODO Auto-generated method stub
	  	
	  	}
	  	
	  	
	  	@Override
	  	public CustomerDTO getCustomerByEmailId(String emailId) throws EKartException {
	  	// TODO Auto-generated method stub
	  	return null;
	  	}
	  	
	  	
}
