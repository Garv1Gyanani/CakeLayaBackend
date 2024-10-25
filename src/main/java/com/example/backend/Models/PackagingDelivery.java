package com.example.backend.Models;

public class PackagingDelivery {
    private Integer deliveryTime; // Delivery time in minutes
    private Integer deliveryRadius; // Delivery radius in kilometers
    private Integer freeDeliveryRadius; // Free delivery radius in kilometers
    private Double orderValueAbove500; // Delivery cost above certain order value
    private Double orderValueBelow500; // Delivery cost below certain order value

    // Getters and Setters
    public Integer getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Integer deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Integer getDeliveryRadius() {
        return deliveryRadius;
    }

    public void setDeliveryRadius(Integer deliveryRadius) {
        this.deliveryRadius = deliveryRadius;
    }

    public Integer getFreeDeliveryRadius() {
        return freeDeliveryRadius;
    }

    public void setFreeDeliveryRadius(Integer freeDeliveryRadius) {
        this.freeDeliveryRadius = freeDeliveryRadius;
    }

    public Double getOrderValueAbove500() {
        return orderValueAbove500;
    }

    public void setOrderValueAbove500(Double orderValueAbove500) {
        this.orderValueAbove500 = orderValueAbove500;
    }

    public Double getOrderValueBelow500() {
        return orderValueBelow500;
    }

    public void setOrderValueBelow500(Double orderValueBelow500) {
        this.orderValueBelow500 = orderValueBelow500;
    }
}
