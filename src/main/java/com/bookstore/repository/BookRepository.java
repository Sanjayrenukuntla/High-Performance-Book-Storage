package com.bookstore.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.model.BookModel;

@Repository
public interface BookRepository extends MongoRepository<BookModel, String> {

	List<BookModel> findByBookName(String bookName);

}
