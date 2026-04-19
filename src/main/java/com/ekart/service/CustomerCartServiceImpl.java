package com.ekart.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ekart.DTO.CartProductDTO;
import com.ekart.DTO.CustomerCartDTO;
import com.ekart.exception.EKartException;
import com.ekart.repo.CustomerCartRepository;

@Service
@Transactional
public class CustomerCartServiceImpl implements CustomerCartService{
  
	@Autowired
	private  CustomerCartRepository cartRepository;
	
	
	@Override
	public Integer addProductToCart(CustomerCartDTO cartDTO) throws EKartException {
		
		return null;
	}
	
	@Override
	public Set<CartProductDTO> getProductsFromCart(String customerEmailId) throws EKartException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void modifyQuantityOfProductInCart(String customerEmailId, Integer productId, Integer quantity)
			throws EKartException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void deleteProductFromCart(String customerEmailId, Integer productId) throws EKartException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void deleteAllProductsFromCart(String customerEmailId) throws EKartException {
		// TODO Auto-generated method stub
		
	}
}
