package com.ekart.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ekart.entity.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction , Integer>{

}
