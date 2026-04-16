package com.ekart.repo;

import org.springframework.data.repository.CrudRepository;

import com.ekart.entity.OrderedProduct;

public interface CustomerOrderedProduct extends CrudRepository<OrderedProduct, Integer> {

}
