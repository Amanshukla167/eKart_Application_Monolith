package com.ekart.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ekart.DTO.CartProductDTO;
import com.ekart.DTO.CustomerCartDTO;
import com.ekart.DTO.ProductDTO;
import com.ekart.entity.CartProduct;
import com.ekart.entity.CustomerCart;
import com.ekart.entity.Product;
import com.ekart.exception.EKartException;
import com.ekart.repo.CartProductRepository;
import com.ekart.repo.CustomerCartRepository;
import com.ekart.repo.ProductRepository;

@Service
@Transactional
public class CustomerCartServiceImpl implements CustomerCartService{
  
	@Autowired
	private CustomerCartRepository cartRepository;
	@Autowired
    private CartProductRepository cartProductRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	
	@Override
	public Integer addProductToCart(CustomerCartDTO cartDTO) throws EKartException {
		
	List<CustomerCart> cartinRepo = cartRepository.findByCustomerEmailIdAndcartId(cartDTO.getCustomerEmailId(), cartDTO.getCartId());
	Set<CartProduct>  cartProductsSet = new HashSet<CartProduct>();
	Integer custId = null;
	
	      if(cartinRepo == null) {
	    	  CustomerCart custEntityCart = new CustomerCart();
	  		
	  		custEntityCart.setCartId(cartDTO.getCartId());
	  		custEntityCart.setCustomerEmailId(cartDTO.getCustomerEmailId());
	  		
	  		
	  		
	  		for(CartProductDTO cartProdDTO : cartDTO.getCartProducts()) {
	  			
	  			CartProduct cartProduct = new CartProduct();
	  			
	  			cartProduct.setCartProductId(cartProdDTO.getCartProductId());
	  			
	         	Optional<Product>	productrepo = 	productRepository.findById(cartProdDTO.getProduct().getProductId());
	  			
	         	Product productobjEntity = 	productrepo.orElseThrow(()-> new EKartException("this  product is not in the product cart"));
	  			
	  			cartProduct.setProductId(productobjEntity.getProducstId());
	  			
	  			cartProduct.setQuantity(cartProdDTO.getQuantity());
	  			
	  			cartProductsSet.add(cartProduct);
	  			
	  		}
	  		
	  		custEntityCart.setCartProducts(cartProductsSet);
	  		
	  		cartRepository.save(custEntityCart);
	  		
	  		custId = custEntityCart.getCartId();
	  		
	      } else {
	    	  
	    	  for ( CustomerCart cartineepo : cartinRepo ) {
	    		  for(CartProductDTO cartproddto2 : cartDTO.getCartProducts() ) {
	 	    		 
	 	    		 CartProduct cartpod = new CartProduct();
	 	    		 
	 	    		 cartpod.setQuantity(cartproddto2.getQuantity());
	 	    		 cartpod.setCartProductId(cartproddto2.getCartProductId());
	 	    		 Optional<Product>	productrepo = 	productRepository.findById(cartproddto2.getProduct().getProductId());
	 		  			
	 		         Product productobjEntity = 	productrepo.orElseThrow(()-> new EKartException("this  product is not in the product cart"));
	 	    		 
	 	    		 cartpod.setProductId(productobjEntity.getProducstId());
	 	    		 
	 	    	   
	 	    	     cartineepo.getCartProducts().add(cartpod);
	 	    	 
	 	    	 }
	    		  custId = cartineepo.getCartId();
	    		  cartRepository.save(cartineepo);
	    	  }
	    	 
	    	
	      }
		
				
		return custId;
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
