package com.bookstore.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bookstore.model.Admin;

public interface AdminRepository  extends MongoRepository<Admin,String>{
     
    
}
