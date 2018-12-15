package com.eshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Product {

    @Transient
    private Integer storedAmount;

    @Id
    @GeneratedValue
    private Long ID;
    private Long productID;
    private String productName;
    private Integer price;

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public int getStoredAmount() {
        return storedAmount;
    }

    public void setStoredAmount(Integer storedAmount) {
        this.storedAmount = storedAmount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
