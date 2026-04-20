package com.ekart.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ekart.entity.CustomerCart;
import java.util.List;


@Repository
public interface CustomerCartRepository extends CrudRepository<CustomerCart, Integer>{
	
   List<CustomerCart> findByCustomerEmailIdAndcartId(String customerEmailId , Integer cartId);
   
}
