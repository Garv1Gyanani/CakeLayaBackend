package com.example.backend.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "shops")
public class Shop {
    @Id
    private String id;
    private String shopName;
    private String fssaiLicenseNumber;
    private Double commissionPercentage;
    private String shopPhotoUrl;
    private PackagingDelivery packagingDelivery;
    private String createdAt; 
    private String updatedAt;
    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getFssaiLicenseNumber() {
        return fssaiLicenseNumber;
    }

    public void setFssaiLicenseNumber(String fssaiLicenseNumber) {
        this.fssaiLicenseNumber = fssaiLicenseNumber;
    }

    public Double getCommissionPercentage() {
        return commissionPercentage;
    }

    public void setCommissionPercentage(Double commissionPercentage) {
        this.commissionPercentage = commissionPercentage;
    }

    public String getShopPhotoUrl() {
        return shopPhotoUrl;
    }

    public void setShopPhotoUrl(String shopPhotoUrl) {
        this.shopPhotoUrl = shopPhotoUrl;
    }

    public PackagingDelivery getPackagingDelivery() {
        return packagingDelivery;
    }

    public void setPackagingDelivery(PackagingDelivery packagingDelivery) {
        this.packagingDelivery = packagingDelivery;
    }

    public String getCreatedAt() { // Corrected capitalization
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() { // Corrected capitalization
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
