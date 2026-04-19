package com.ekart.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ekart.entity.CartProduct;

@Repository
public interface CartProductRepository extends CrudRepository<CartProduct, Integer>{

}
