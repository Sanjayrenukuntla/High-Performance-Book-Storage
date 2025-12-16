package com.bookstore.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.model.UserModel;

@Repository
public interface UserRepository  extends  MongoRepository<UserModel,Integer>{

    UserModel findByUserNameAndPassword(String userName, String password);

    UserModel findByUserName(String userid);

    
} 
