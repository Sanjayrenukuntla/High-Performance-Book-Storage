package com.bookstore.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.model.PublisherModel;


@Repository
public interface PublisherRepository extends  MongoRepository<PublisherModel,String>{
    
}
