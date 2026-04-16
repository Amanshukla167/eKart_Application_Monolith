package com.ekart.repo;

import org.springframework.data.repository.CrudRepository;

import com.ekart.entity.CustomerCart;

public interface CustomerCartRepository extends CrudRepository<CustomerCart, Integer>{

}
