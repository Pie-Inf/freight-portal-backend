package com.freightportal.dto;

import com.freightportal.model.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

class LoadDTO {
    private String id;
    private String loadNumber;
    private String shipperName;
    private String pickupLocation;
    private String deliveryLocation;
    private String cargoType;
    private double weight;
    private BigDecimal rate;
    private String status;
    private LocalDateTime pickupDate;

    // Constructor
    public LoadDTO() {
    }

    public static LoadDTO fromLoad(Load load) {
        LoadDTO dto = new LoadDTO();
        dto.setId(load.getId());
        dto.setLoadNumber(load.getLoadNumber());
        dto.setShipperName(load.getShipperName());
        dto.setPickupLocation(load.getPickup().getCity() + ", " + load.getPickup().getState());
        dto.setDeliveryLocation(load.getDelivery().getCity() + ", " + load.getDelivery().getState());
        dto.setCargoType(load.getCargo().getType());
        dto.setWeight(load.getCargo().getWeight());
        dto.setRate(load.getRate());
        dto.setStatus(load.getStatus().name());
        dto.setPickupDate(load.getPickupDate());
        return dto;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoadNumber() {
        return loadNumber;
    }

    public void setLoadNumber(String loadNumber) {
        this.loadNumber = loadNumber;
    }

    public String getShipperName() {
        return shipperName;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDeliveryLocation() {
        return deliveryLocation;
    }

    public void setDeliveryLocation(String deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDateTime pickupDate) {
        this.pickupDate = pickupDate;
    }
}
