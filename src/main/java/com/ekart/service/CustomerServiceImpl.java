package com.ekart.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ekart.DTO.CustomerDTO;
import com.ekart.exception.EKartException;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    
	    
	
		@Override
		public CustomerDTO authenticateCustomer(String emailId, String password) throws EKartException {
		// TODO Auto-generated method stub
		return null;
		}
		
		
	  
	  	@Override
	  	public String registerNewCustomer(CustomerDTO customerDTO) throws EKartException {
	  		// TODO Auto-generated method stub
	  		return null;
	  	}
	  	
	  	
	  	@Override
	  	public void updateShippingAddress(String customerEmailId, String address) throws EKartException {
	  	// TODO Auto-generated method stub
	  	
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
