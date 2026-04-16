package com.ekart.repo;

import org.springframework.data.repository.CrudRepository;

import com.ekart.entity.Customer;

public interface CustomerRepository  extends CrudRepository<Customer, String>{

}
