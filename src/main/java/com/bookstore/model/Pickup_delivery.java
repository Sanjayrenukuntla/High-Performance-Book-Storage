package com.bookstore.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection  = "pickup_delivery")
public class Pickup_delivery {

    @Id
    private String pickupId;
    private OrderModel orderModel;
    private UserModel userModel;
    public String getPickupId() {
        return pickupId;
    }
    public void setPickupId(String pickupId) {
        this.pickupId = pickupId;
    }
    public OrderModel getOrderModel() {
        return orderModel;
    }
    public void setOrderModel(OrderModel orderModel) {
        this.orderModel = orderModel;
    }
    public UserModel getUserModel() {
        return userModel;
    }
    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    
    
}
