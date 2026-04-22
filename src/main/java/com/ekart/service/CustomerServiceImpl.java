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
		 Optional<Customer> foundItem = customerRepository.findById(emailId);
		 
		 CustomerDTO customerDTO = new CustomerDTO();
		 
		 Customer customerobj = foundItem.orElseThrow(() -> new EKartException("the Customer Dose not exist of by Email id, please try with diffrent one"));
		   
				 if(customerobj.getPassword().equals(password)){
					 
					 customerDTO.setName(customerobj.getName());
					 customerDTO.setEmailId(customerobj.getEmailId());
					 customerDTO.setPhoneNumber(customerobj.getPhoneNumber());
					 customerDTO.setAddress(customerobj.getAddress());
					 
				 }else {
					 throw new EKartException("Pleae Emter the correct password");
				 }
				 
		return customerDTO;
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
	  	
	  		
	  	Optional<Customer> custIdfound	= customerRepository.findById(customerEmailId);
	  	
    	Customer custObj = custIdfound.orElseThrow(()-> new EKartException("The address does not exit of this Emailid"));
    	
    	custObj.setAddress(null);
    	
    	customerRepository.save(custObj);
	  	
	  	}
	  	
	  	
	  	@Override
	  	public CustomerDTO getCustomerByEmailId(String emailId) throws EKartException {
	  	   
	  	Optional<Customer> foundobj = customerRepository.findById(emailId);
	  	
	  	Customer custobj = foundobj.orElseThrow(()-> new EKartException("The Customer Does Not exist, please try with diffrent ID"));
	  		
	  	CustomerDTO customerDTO = new CustomerDTO();
	  	
	  	customerDTO.setName(custobj.getName());
	  	customerDTO.setEmailId(custobj.getEmailId());
	  	customerDTO.setAddress(custobj.getAddress());
	  	customerDTO.setPhoneNumber(custobj.getPhoneNumber());
	  		
	  	return customerDTO;
	  	}
	  	
	  	
}
