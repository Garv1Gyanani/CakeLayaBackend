package com.example.backend.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "offers")
public class Offer {
    @Id
    private String offerId;
    private double productDiscount;
    private String promocode;
    private String createdAt;
    private String shopId; 

    public Offer() {}

    public Offer(String offerId, double productDiscount, String promocode, String createdAt, String shopId) {
        this.offerId = offerId;
        this.productDiscount = productDiscount;
        this.promocode = promocode;
        this.createdAt = createdAt;
        this.shopId = shopId;
    }

    // Getters and Setters...
    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public double getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(double productDiscount) {
        this.productDiscount = productDiscount;
    }

    public String getPromocode() {
        return promocode;
    }

    public void setPromocode(String promocode) {
        this.promocode = promocode;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }
}
