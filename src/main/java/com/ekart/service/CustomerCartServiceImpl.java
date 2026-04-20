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
		
		Integer cartId = null;
		Set<CartProduct> Customercartproduct = new HashSet<CartProduct>();
		
		List<CustomerCart> cartInDatabase = cartRepository.findByCustomerEmailIdAndcartId(cartDTO.getCustomerEmailId(),cartDTO.getCartId());
		
		if(cartInDatabase == null) {
			CustomerCart custEntity = new CustomerCart();
			
			
			
			custEntity.setCartId(cartDTO.getCartId());
			custEntity.setCustomerEmailId(cartDTO.getCustomerEmailId());
			  
		     for(CartProductDTO cartdto : cartDTO.getCartProducts() ) {
		    	 Optional<Product> prodt = productRepository.findById(cartdto.getProduct().getProductId());
			    	
				
		    	 Product prodtEntity  = prodt.orElseThrow(() -> new EKartException("the product you are lookig for is not in the database"));
		    	 CartProduct cartProdudtEntity = new CartProduct();
		    	 
		    	 cartProdudtEntity.setProductId(prodtEntity.getProducstId());
		    	 cartProdudtEntity.setQuantity(cartdto.getQuantity());    
		    	 Customercartproduct.add(cartProdudtEntity);
		    	
		     }
			
			custEntity.setCartProducts(Customercartproduct);
			
			cartRepository.save(custEntity);
			
			 cartId = custEntity.getCartId();;
		}else {
			
			for(CustomerCart custCartEntity : cartInDatabase) {
				
				 for(CartProductDTO cartdto : cartDTO.getCartProducts() ) {
			    	 Optional<Product> prodt = productRepository.findById(cartdto.getProduct().getProductId());
				    	
					
			    	 Product prodtEntity  = prodt.orElseThrow(() -> new EKartException("the product you are lookig for is not in the database"));
			    	 CartProduct cartProdudtEntity = new CartProduct();
			    	 
			    	 cartProdudtEntity.setProductId(prodtEntity.getProducstId());
			    	 cartProdudtEntity.setQuantity(cartdto.getQuantity());    
			    	 Customercartproduct.add(cartProdudtEntity);
			    	
			     }
				
			}
		}
		

		
		return cartId;
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
