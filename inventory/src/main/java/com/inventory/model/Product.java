package com.inventory.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long ID;
    private Long productID;
    private int storedAmount;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public int getStoredAmount() {
        return storedAmount;
    }

    public void setStoredAmount(int storedAmount) {
        this.storedAmount = storedAmount;
    }

}
