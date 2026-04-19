package com.ekart.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ekart.entity.OrderedProduct;

@Repository
public interface CustomerOrderedProduct extends CrudRepository<OrderedProduct, Integer> {

}
