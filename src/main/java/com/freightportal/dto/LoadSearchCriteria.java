
package com.freightportal.dto;

import com.freightportal.model.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

class LoadSearchCriteria {

    private String pickupCity;
    private String pickupState;
    private String deliveryCity;
    private String deliveryState;
    private String cargoType;

    private Double minWeight;
    private Double maxWeight;

    private BigDecimal minRate;
    private BigDecimal maxRate;

    private LocalDateTime pickupDateFrom;
    private LocalDateTime pickupDateTo;

    private LoadStatus status;
    private String sortBy = "createdAt,desc";

    // Constructors
    public LoadSearchCriteria() {
    }

    // Getters and Setters
    public String getPickupCity() {
        return pickupCity;
    }

    public void setPickupCity(String pickupCity) {
        this.pickupCity = pickupCity;
    }

    public String getPickupState() {
        return pickupState;
    }

    public void setPickupState(String pickupState) {
        this.pickupState = pickupState;
    }

    public String getDeliveryCity() {
        return deliveryCity;
    }

    public void setDeliveryCity(String deliveryCity) {
        this.deliveryCity = deliveryCity;
    }

    public String getDeliveryState() {
        return deliveryState;
    }

    public void setDeliveryState(String deliveryState) {
        this.deliveryState = deliveryState;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    public Double getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(Double minWeight) {
        this.minWeight = minWeight;
    }

    public Double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public BigDecimal getMinRate() {
        return minRate;
    }

    public void setMinRate(BigDecimal minRate) {
        this.minRate = minRate;
    }

    public BigDecimal getMaxRate() {
        return maxRate;
    }

    public void setMaxRate(BigDecimal maxRate) {
        this.maxRate = maxRate;
    }

    public LocalDateTime getPickupDateFrom() {
        return pickupDateFrom;
    }

    public void setPickupDateFrom(LocalDateTime pickupDateFrom) {
        this.pickupDateFrom = pickupDateFrom;
    }

    public LocalDateTime getPickupDateTo() {
        return pickupDateTo;
    }

    public void setPickupDateTo(LocalDateTime pickupDateTo) {
        this.pickupDateTo = pickupDateTo;
    }

    public LoadStatus getStatus() {
        return status;
    }

    public void setStatus(LoadStatus status) {
        this.status = status;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }
}