package com.bookstore.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;





@Document(collection  = "order")
public class OrderModel {

    @Id
    private String orderId;
    private String orderedDate;
    private List<BookModel> listofBooks;
    private String userId;
    private String orderStatus;
    private paymentModel paymentModel;

    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public String getOrderedDate() {
        return orderedDate;
    }
    public void setOrderedDate(String orderedDate) {
        this.orderedDate = orderedDate;
    }
    public List<BookModel> getListofBooks() {
        return listofBooks;
    }
    public void setListofBooks(List<BookModel> listofBooks) {
        this.listofBooks = listofBooks;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    public paymentModel getPaymentModel() {
        return paymentModel;
    }
    public void setPaymentModel(paymentModel paymentModel) {
        this.paymentModel = paymentModel;
    }
    

    
    
    
}
