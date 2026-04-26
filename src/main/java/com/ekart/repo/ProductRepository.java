package com.ekart.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ekart.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{
    
	
	
	
}
