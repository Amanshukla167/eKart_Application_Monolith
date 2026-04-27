package com.ekart.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ekart.entity.Order;
import java.util.List;



@Repository
public interface CustomerOrderRepository extends CrudRepository<Order, Integer>{
    
	   
	    List<Order> findByCustomerEmaiId(String customerEmaiId);
	
	
}
