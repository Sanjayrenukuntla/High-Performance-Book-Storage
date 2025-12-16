package com.bookstore.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection  = "books")
public class BookModel {
	
	@Id
	private String bookId;
	private String bookName;
	private String bookIsn;
	private AuthorModel authorModel;
	private PublisherModel publisherModel;
	private String bookUrl;

	@Id
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookIsn() {
		return bookIsn;
	}
	public void setBookIsn(String bookIsn) {
		this.bookIsn = bookIsn;
	}
	public AuthorModel getAuthorModel() {
		return authorModel;
	}
	public void setAuthorModel(AuthorModel authorModel) {
		this.authorModel = authorModel;
	}
	public PublisherModel getPublisherModel() {
		return publisherModel;
	}
	public void setPublisherModel(PublisherModel publisherModel) {
		this.publisherModel = publisherModel;
	}
	public String getBookUrl() {
		return bookUrl;
	}
	public void setBookUrl(String bookUrl) {
		this.bookUrl = bookUrl;
	}

	
	

}
