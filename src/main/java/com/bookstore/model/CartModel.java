package com.bookstore.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection  = "cart")
public class CartModel {

    @Id
    private String cartId;
    private BookModel bookModel;
    private String userId;

    
    public BookModel getBookModel() {
        return bookModel;
    }
    public void setBookModel(BookModel bookModel) {
        this.bookModel = bookModel;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getCartId() {
        return cartId;
    }
    public void setCartId(String cartId) {
        this.cartId = cartId;
    }


    

    
}
