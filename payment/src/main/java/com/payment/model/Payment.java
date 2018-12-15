package com.payment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Payment {


    @Id
    @GeneratedValue
    private Long Id;
    private Long productID;
    private int price;
    private boolean paid;

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
