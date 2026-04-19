package com.ekart.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ekart.entity.Customer;

@Repository
public interface CustomerRepository  extends CrudRepository<Customer, String>{

}
