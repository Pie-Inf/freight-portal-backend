package com.freightportal.dto;

import com.freightportal.model.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class CreateFleetRequest {
    @NotBlank private String carrierId;
    @NotBlank private String carrierName;
    @NotNull private Vehicle vehicle;
    @NotNull private Driver driver;
    private Location currentLocation;
    private List<String> preferredRoutes;
    @NotNull private LocalDateTime availableFrom;
    @NotNull private LocalDateTime availableUntil;
    @NotNull private BigDecimal ratePerMile;
    private String currency = "USD";

    // Getters and Setters
    public String getCarrierId() { return carrierId; }
    public void setCarrierId(String carrierId) { this.carrierId = carrierId; }
    
    public String getCarrierName() { return carrierName; }
    public void setCarrierName(String carrierName) { this.carrierName = carrierName; }
    
    public Vehicle getVehicle() { return vehicle; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
    
    public Driver getDriver() { return driver; }
    public void setDriver(Driver driver) { this.driver = driver; }
    
    public Location getCurrentLocation() { return currentLocation; }
    public void setCurrentLocation(Location currentLocation) { 
        this.currentLocation = currentLocation; 
    }
    
    public List<String> getPreferredRoutes() { return preferredRoutes; }
    public void setPreferredRoutes(List<String> preferredRoutes) { 
        this.preferredRoutes = preferredRoutes; 
    }
    
    public LocalDateTime getAvailableFrom() { return availableFrom; }
    public void setAvailableFrom(LocalDateTime availableFrom) { 
        this.availableFrom = availableFrom; 
    }
    
    public LocalDateTime getAvailableUntil() { return availableUntil; }
    public void setAvailableUntil(LocalDateTime availableUntil) { 
        this.availableUntil = availableUntil; 
    }
    
    public BigDecimal getRatePerMile() { return ratePerMile; }
    public void setRatePerMile(BigDecimal ratePerMile) { 
        this.ratePerMile = ratePerMile; 
    }
    
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
}