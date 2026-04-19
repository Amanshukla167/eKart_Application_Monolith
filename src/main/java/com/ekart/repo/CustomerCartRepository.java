package com.ekart.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ekart.entity.CustomerCart;

@Repository
public interface CustomerCartRepository extends CrudRepository<CustomerCart, Integer>{

}
