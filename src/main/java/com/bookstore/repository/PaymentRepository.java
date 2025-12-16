package com.bookstore.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bookstore.model.paymentModel;

public interface PaymentRepository extends MongoRepository<paymentModel,String> {
    
}
