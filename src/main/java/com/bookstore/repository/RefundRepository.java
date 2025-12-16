package com.bookstore.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.model.Refund_policy;

@Repository
public interface RefundRepository  extends MongoRepository<Refund_policy,String>{
    
}
