package com.bookstore.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.model.AuthorModel;

@Repository
public interface AuthorRepository extends MongoRepository<AuthorModel,String>{
    
}
