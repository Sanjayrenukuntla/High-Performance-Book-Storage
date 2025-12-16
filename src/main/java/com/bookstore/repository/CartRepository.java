package com.bookstore.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.model.CartModel;

@Repository
public interface CartRepository extends MongoRepository<CartModel, String>{


    List<CartModel> findByUserId(String userName);
    
}
