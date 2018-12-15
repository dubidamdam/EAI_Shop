package com.eshop;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "productName",
        "price",
        "storedAmount",
        "amount",
        "productID"
})
public class Parameters {

    @JsonProperty("productName")
    private String productName;
    @JsonProperty("price")
    private Long price;
    @JsonProperty("storedAmount")
    private Long storedAmount;
    @JsonProperty("amount")
    private Long amount;
    @JsonProperty("productID")
    private Long productID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("productName")
    public String getProductName() {
        return productName;
    }

    @JsonProperty("productName")
    public void setProductName(String productName) {
        this.productName = productName;
    }

    @JsonProperty("price")
    public Long getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Long price) {
        this.price = price;
    }

    @JsonProperty("storedAmount")
    public Long getStoredAmount() {
        return storedAmount;
    }

    @JsonProperty("storedAmount")
    public void setStoredAmount(Long storedAmount) {
        this.storedAmount = storedAmount;
    }

    @JsonProperty("amount")
    public Long getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @JsonProperty("productID")
    public Long getProductID() {
        return productID;
    }

    @JsonProperty("productID")
    public void setProductID(Long productID) {
        this.productID = productID;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
