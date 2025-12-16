package com.bookstore.model;

import org.springframework.data.mongodb.core.mapping.Document;




@Document(collection  = "author")
public class AuthorModel {

    private String authorId;
    private String authorName;
    private String authorAddress;
    public String getAuthorId() {
        return authorId;
    }
    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public String getAuthorAddress() {
        return authorAddress;
    }
    public void setAuthorAddress(String authorAddress) {
        this.authorAddress = authorAddress;
    }

    
    
}
