package com.ekart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ekart.DTO.ProductDTO;
import com.ekart.entity.Product;
import com.ekart.exception.EKartException;
import com.ekart.repo.ProductRepository;


@Service
@Transactional
public class CustomerProductServiceImpl implements CustomerProductService{
   
	   @Autowired
	   private ProductRepository productRepository;
	
	     @Override
	    public List<ProductDTO> getAllProducts() throws EKartException {
	    	 
	    	 List<ProductDTO> prodList = new ArrayList<ProductDTO>();
	    	 
	        List<Product> prodobj = (List<Product>) productRepository.findAll();
	        
	        if(prodobj.isEmpty()) {
	        	throw new EKartException("there is no product is avalible");
	        }
	        
	        for(Product prodformTable : prodobj) {
	        	     ProductDTO dto = new ProductDTO();
		    		 
		    		 dto.setName(prodformTable.getName());
		    		 dto.setBrand(prodformTable.getBrand());
		    		 dto.setCategory(prodformTable.getCategory());
		    		 dto.setDescription(prodformTable.getDescription());
		    		 dto.setAvailableQuantity(prodformTable.getAvailableQuantity());
		    		 dto.setProductId(prodformTable.getProducstId());
		    		 dto.setPrice(prodformTable.getPrice());
		    		 
		    		 prodList.add(dto);
	        }
	
	    	return prodList;
	    }
	     
	     
	     
	     
	     @Override
	    public ProductDTO getProductById(Integer productId) throws EKartException {
	    	 
				Optional<Product> productobj = productRepository.findById(productId);
				
				Product product = productobj.orElseThrow(()-> new EKartException("Producr does not exist by this id please try with diffrent id"));
                
				ProductDTO dto = new ProductDTO();
				
				 dto.setName(product.getName());
	    		 dto.setBrand(product.getBrand());
	    		 dto.setCategory(product.getCategory());
	    		 dto.setDescription(product.getDescription());
	    		 dto.setAvailableQuantity(product.getAvailableQuantity());
	    		 dto.setProductId(product.getProducstId());
	    		 dto.setPrice(product.getPrice());
		
	              return dto;
	    }
	     
	     
	     
	     @Override
	    public void reduceAvailableQuantity(Integer productId, Integer quantity) throws EKartException {
	    	 	
	    	 
	    	Optional<Product> prodobj =  productRepository.findById(productId);
	    	
	        Product product = prodobj.orElseThrow(()-> new EKartException("the product is not found , please try with the diffrent id"));
	    	
	        if(quantity <= product.getAvailableQuantity()) {
	        	product.setAvailableQuantity(product.getAvailableQuantity() - quantity);
	        	 productRepository.save(product);
	        }else {
	        	throw new EKartException("the Max quantity you can order for the product is  " + product.getAvailableQuantity());
	        }
	        
	    }
	    
	     
		
	 	
			
}
