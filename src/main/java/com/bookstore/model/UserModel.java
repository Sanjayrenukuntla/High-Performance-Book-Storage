package com.bookstore.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "user")
public class UserModel {

    @Id
    private String id;
    private String userName;
    private String password;
    private String userType;
    private String emailId;
    private String phoneNubmer;
    private String address;
    private List<OrderModel> orderModels;
    private List<CartModel> cartModels;
    
    public String getId() {

        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUserType() {
        return userType;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public String getPhoneNubmer() {
        return phoneNubmer;
    }
    public void setPhoneNubmer(String phoneNubmer) {
        this.phoneNubmer = phoneNubmer;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public List<OrderModel> getOrderModels() {
        return orderModels;
    }
    public void setOrderModels(List<OrderModel> orderModels) {
        this.orderModels = orderModels;
    }
    public List<CartModel> getCartModels() {
        return cartModels;
    }
    public void setCartModels(List<CartModel> cartModels) {
        this.cartModels = cartModels;
    }


    
}
