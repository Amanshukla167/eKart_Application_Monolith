package com.ekart.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ekart.entity.Order;


@Repository
public interface CustomerOrderRepository extends CrudRepository<Order, Integer>{

}
