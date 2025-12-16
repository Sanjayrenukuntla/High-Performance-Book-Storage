package com.bookstore.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.model.Pickup_delivery;

@Repository
public interface PickupRepository  extends MongoRepository<Pickup_delivery, String>{
    
}
