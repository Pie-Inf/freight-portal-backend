package com.freightportal.dto;

import com.freightportal.model.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class CreateLoadRequest {

    @NotBlank(message = "Shipper ID is required")
    private String shipperId;

    @NotBlank(message = "Shipper name is required")
    private String shipperName;

    @NotNull(message = "Pickup location is required")
    private Location pickup;

    @NotNull(message = "Delivery location is required")
    private Location delivery;

    @NotNull(message = "Cargo details are required")
    private Cargo cargo;

    @NotNull(message = "Rate is required")
    @DecimalMin(value = "0.0", message = "Rate must be positive")
    private BigDecimal rate;

    private String currency = "USD";

    @NotNull(message = "Pickup date is required")
    private LocalDateTime pickupDate;

    @NotNull(message = "Delivery date is required")
    private LocalDateTime deliveryDate;

    private List<String> specialRequirements;
    private String notes;

    // Constructors
    public CreateLoadRequest() {
    }

    // Getters and Setters
    public String getShipperId() {
        return shipperId;
    }

    public void setShipperId(String shipperId) {
        this.shipperId = shipperId;
    }

    public String getShipperName() {
        return shipperName;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

    public Location getPickup() {
        return pickup;
    }

    public void setPickup(Location pickup) {
        this.pickup = pickup;
    }

    public Location getDelivery() {
        return delivery;
    }

    public void setDelivery(Location delivery) {
        this.delivery = delivery;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDateTime getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDateTime pickupDate) {
        this.pickupDate = pickupDate;
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public List<String> getSpecialRequirements() {
        return specialRequirements;
    }

    public void setSpecialRequirements(List<String> specialRequirements) {
        this.specialRequirements = specialRequirements;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
