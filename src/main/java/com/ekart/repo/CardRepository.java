package com.ekart.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ekart.entity.Card;
import java.util.List;



@Repository
public interface CardRepository extends CrudRepository<Card, Integer> {


}
