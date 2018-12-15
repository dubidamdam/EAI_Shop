package com.payment.model;

public class Item {
    public Long productID;
    public int amount;

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
