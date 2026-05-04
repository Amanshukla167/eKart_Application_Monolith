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
		
	List<CustomerCart> cartinRepo = cartRepository.findByCustomerEmailId(cartDTO.getCustomerEmailId());
	Set<CartProduct>  cartProductsSet = new HashSet<CartProduct>();
	Integer custId = null;
	
	      if(cartinRepo == null || cartinRepo.isEmpty()) {
	    	  CustomerCart custEntityCart = new CustomerCart();
	  		
//	  		custEntityCart.setCartId(cartDTO.getCartId());
	  		custEntityCart.setCustomerEmailId(cartDTO.getCustomerEmailId());
	  		
	  		
	  		
	  		for(CartProductDTO cartProdDTO : cartDTO.getCartProducts()) {
	  			
	  			CartProduct cartProduct = new CartProduct();
	  			
//	  			cartProduct.setCartProductId(cartProdDTO.getCartProductId());
	  			
	         	Optional<Product>	productrepo = 	productRepository.findById(cartProdDTO.getProductID());
	  			
	         	Product productobjEntity = 	productrepo.orElseThrow(()-> new EKartException("this  product is not in the product cart"));
	  			
	  			cartProduct.setProductId(productobjEntity.getproductId());
	  			
	  			cartProduct.setQuantity(cartProdDTO.getQuantity());
	  			
	  			cartProductsSet.add(cartProduct);
	  			
	  		}
	  		
	  		custEntityCart.setCartProducts(cartProductsSet);
	  		
	  		cartRepository.save(custEntityCart);
	  		
	  		custId = custEntityCart.getCartId();
	  		
	      } else {
	    	  
	    	 
	    	  
	    	   CustomerCart custcart =  cartinRepo.get(0); 
	    	   
	    	   Set<CartProduct>  cartProductsSet2 = custcart.getCartProducts();
	    	  
	    		  for(CartProductDTO cartproddto2 : cartDTO.getCartProducts() ) {
	 	    		 
	 	    		 CartProduct cartpod = new CartProduct();
	 	    		 
	 	    		 cartpod.setQuantity(cartproddto2.getQuantity());
	 	    		 cartpod.setCartProductId(cartproddto2.getCartProductId());
	 	    		 Optional<Product>	productrepo = 	productRepository.findById(cartproddto2.getProduct().getProductId());
	 		  			
	 		         Product productobjEntity = 	productrepo.orElseThrow(()-> new EKartException("this  product is not in the product cart"));
	 	    		 
	 	    		 cartpod.setProductId(productobjEntity.getproductId());
	 	    		  
	 	    		cartProductsSet2.add(cartpod);
	 	    	     custcart.setCartProducts(cartProductsSet2);
//	 	    	      custcart.getCartProducts().add(cartpod);
	 	    	      cartRepository.save(custcart);
	 	    	 }
	    		  custId = custcart.getCartId();
	    	}
		return custId;
	}
	
	@Override
	public Set<CartProductDTO> getProductsFromCart(String customerEmailId) throws EKartException {
		
	List<CustomerCart> custCart = cartRepository.findByCustomerEmailId(customerEmailId);
	
	Set<CartProductDTO> cartProductDetails = new HashSet<CartProductDTO>();
	 
	  if(custCart == null ||  custCart.isEmpty()) {
		  throw new EKartException("the cart is does not exist of this customer " +  customerEmailId);
		  
	  }
	  
	  for(CustomerCart custcart2 : custCart ) {
		   
		Set<CartProduct> cartPod = custcart2.getCartProducts();
		 
		  for(CartProduct cartProduct : cartPod) {
			  
			  CartProductDTO cartProductDTO = new CartProductDTO();
			  
			  cartProductDTO.setCartProductId(cartProduct.getCartProductId());
			  cartProductDTO.setQuantity(cartProduct.getQuantity());
			  
		     Optional<Product>	itemInPord = productRepository.findById(cartProduct.getProductId());
		   
		     Product proditem =  itemInPord.orElseThrow(()-> new EKartException("there is no product in this cart of this profuct ID" + cartProduct.getProductId()));
		     
		     ProductDTO prodDto = new ProductDTO();
		     
		     prodDto.setBrand(proditem.getBrand());
		     prodDto.setCategory(proditem.getCategory());
		     prodDto.setName(proditem.getName());
		     prodDto.setPrice(proditem.getPrice());
		     prodDto.setAvailableQuantity(proditem.getAvailableQuantity());
		     prodDto.setDescription(proditem.getDescription());
		     prodDto.setProductId(proditem.getproductId());
		     
		     cartProductDTO.setProduct(prodDto);
		     
		     cartProductDetails.add(cartProductDTO);
		  }	  
	   }
		
		return cartProductDetails;
	}
	
	@Override
	public void modifyQuantityOfProductInCart(String customerEmailId, Integer productId, Integer quantity)throws EKartException {
		
			List<CustomerCart>iteminCustCart = cartRepository.findByCustomerEmailId(customerEmailId);
			
			if(iteminCustCart == null || iteminCustCart.isEmpty()) {
				throw new EKartException("the Cart is empty or either the cart not found");
			}
			
			CustomerCart custCart = iteminCustCart.get(0);
			
			  Set<CartProduct> cartprod =  custCart.getCartProducts();
			  
			  for( CartProduct cartproduct : cartprod) {
				  if(cartproduct.getProductId().equals(productId)) {
					  Optional<Product>itemInProduct = productRepository.findById(productId);
					   Product product = itemInProduct.orElseThrow(()-> new EKartException("the item not found in the card of product ID" + productId));
					   
					   cartproduct.setQuantity(quantity); 
					   
					   
					   cartProductRepository.save(cartproduct);
				  }
			  }
		
	}
	
	@Override
	public void deleteProductFromCart(String customerEmailId, Integer productId) throws EKartException {
		
			List<CustomerCart>iteminCart = cartRepository.findByCustomerEmailId(customerEmailId);
			
			if(iteminCart == null || iteminCart.isEmpty()) {
				throw new EKartException("the cart is does not exit or the cart is empty");
			}
			
			  CustomerCart custCart = iteminCart.get(0);
			  
			  Set<CartProduct> custfromCart  = custCart.getCartProducts();
			  
			  for(CartProduct cartprod :custfromCart ) {
				  
				  if(cartprod.getProductId().equals(productId)) {
					  
                        	 custfromCart.remove(cartprod);
        					 cartProductRepository.delete((CartProduct)cartprod);
        					 cartRepository.save(custCart);
        					 return;
				  }
				  
			  }
				
	}
	
	@Override
	public void deleteAllProductsFromCart(String customerEmailId) throws EKartException {
		List<CustomerCart>iteminCart = cartRepository.findByCustomerEmailId(customerEmailId);
		
		if(iteminCart == null || iteminCart.isEmpty()) {
			throw new EKartException("the cart is does not exit or the cart is empty");
		}
		
		 CustomerCart custCart = iteminCart.get(0);
		
		 Set<CartProduct> custfromCart  = custCart.getCartProducts();
		
		 if(custfromCart ==  null || custfromCart.isEmpty()) {
			 throw new EKartException("The Cart is empty can not be delteted");
			
		 }
		 
		 
		 
		 custfromCart.removeAll(custfromCart);
		 
		 cartProductRepository.deleteAll(custfromCart);
		 cartRepository.save(custCart);
		 
		
	}
}
