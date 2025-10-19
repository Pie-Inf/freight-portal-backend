package com.freightportal.model;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.*;

import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
@Document(collection = "fleets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fleet {
    @Id
    private String id;

    @NotNull
    private String carrierId;

    private String carrierName;

    @NotNull
    private Vehicle vehicle;

    @NotNull
    private Driver driver;

    private Location currentLocation;

    private List<String> preferredRoutes;

    @Enumerated(EnumType.STRING)
    private FleetStatus status = FleetStatus.AVAILABLE;

    private LocalDateTime availableFrom;
    private LocalDateTime availableUntil;

    private BigDecimal ratePerMile;
    private String currency = "USD";

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}

