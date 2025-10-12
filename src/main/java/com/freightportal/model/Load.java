package com.freightportal.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.Instant;

@Document(collection = "loads")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Load {
    @Id
    private String id;

    @NotBlank
    private String loadNumber;

    @NotNull
    private String shipperId;

    private String shipperName;

    @NotNull
    private Location pickup;

    @NotNull
    private Location delivery;

    @NotNull
    private Cargo cargo;

    @NotNull
    private BigDecimal rate;

    @NotNull
    private String currency = "USD";

    @Enumerated(EnumType.STRING)
    private LoadStatus status = LoadStatus.AVAILABLE;

    private LocalDateTime postedDate;
    private LocalDateTime pickupDate;
    private LocalDateTime deliveryDate;

    private List<String> specialRequirements;
    private String notes;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private double[] coordinates; // [longitude, latitude] for MongoDB geospatial
}

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cargo {
    private String type;
    private double weight;
    private String weightUnit = "lbs";
    private Dimensions dimensions;
    private String description;
    private List<String> specialHandling;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dimensions {
    private double length;
    private double width;
    private double height;
    private String unit = "ft";
}

public enum LoadStatus {
    AVAILABLE, ASSIGNED, IN_TRANSIT, DELIVERED, CANCELLED
}
