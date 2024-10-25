package com.example.backend.Models;

public class PackagingDelivery {
    private Integer deliveryTime; 
    private Integer deliveryRadius;
    private Integer freeDeliveryRadius; 
    private Double orderValueAbove500; 
    private Double orderValueBelow500;

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
