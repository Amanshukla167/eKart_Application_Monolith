package com.ekart.repo;

import org.springframework.data.repository.CrudRepository;

import com.ekart.entity.Order;

public interface CustomerOrderRepository extends CrudRepository<Order, Integer>{

}
