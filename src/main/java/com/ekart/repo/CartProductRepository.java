package com.ekart.repo;

import org.springframework.data.repository.CrudRepository;

import com.ekart.entity.CartProduct;

public interface CartProductRepository extends CrudRepository<CartProduct, Integer>{

}
