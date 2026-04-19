package com.ekart.service;

import com.ekart.DTO.CustomerCartDTO;
import com.ekart.exception.EKartException;

public interface CustomerCartService {
    
	Integer addProductToCart(CustomerCartDTO cartDTO) throws EKartException;
	
	
}
