package com.bookstore.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;

@Document(collection  = "publisher")
public class PublisherModel {

    private String publisherId;
    private String publisherName;
    private String publisherAddress;
    private String bookCost;
    public String getPublisherId() {
        return publisherId;
    }
    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }
    public String getPublisherName() {
        return publisherName;
    }
    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }
    public String getPublisherAddress() {
        return publisherAddress;
    }
    public void setPublisherAddress(String publisherAddress) {
        this.publisherAddress = publisherAddress;
    }
    public String getBookCost() {
        return bookCost;
    }
    public void setBookCost(String bookCost) {
        this.bookCost = bookCost;
    }

    
    
}
