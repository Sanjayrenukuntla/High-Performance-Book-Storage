package com.bookstore.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection  = "Return_policy")
public class Refund_policy {

    private String retrunId;
    private OrderModel orderModel;
    
    public String getRetrunId() {
        return retrunId;
    }
    public void setRetrunId(String retrunId) {
        this.retrunId = retrunId;
    }
    public OrderModel getOrderModel() {
        return orderModel;
    }
    public void setOrderModel(OrderModel orderModel) {
        this.orderModel = orderModel;
    }

    
    
}
