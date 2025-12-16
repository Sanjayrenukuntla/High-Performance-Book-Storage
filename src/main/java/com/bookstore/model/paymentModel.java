package com.bookstore.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection  = "payment")
public class paymentModel {

    @Id
    private String paymentId;
    private String paymentStatus;
    private String paymenttype;
    private String paymentCard;
    
    public String getPaymentId() {
        return paymentId;
    }
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }
    public String getPaymentStatus() {
        return paymentStatus;
    }
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    public String getPaymenttype() {
        return paymenttype;
    }
    public void setPaymenttype(String paymenttype) {
        this.paymenttype = paymenttype;
    }
    public String getPaymentCard() {
        return paymentCard;
    }
    public void setPaymentCard(String paymentCard) {
        this.paymentCard = paymentCard;
    }

    
    

    
}
