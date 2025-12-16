package com.bookstore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.model.BookModel;
import com.bookstore.model.OrderModel;

@Repository
public interface OrderRepository extends MongoRepository<OrderModel, String> {

    List<OrderModel> findByUserId(String userName);

    Optional<OrderModel> findByOrderId(String orderId);
    
}
