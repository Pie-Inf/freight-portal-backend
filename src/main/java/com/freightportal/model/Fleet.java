package com.freightportal.model;

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

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    private String type; // truck, van, trailer
    private String make;
    private String model;
    private int year;
    private String plateNumber;
    private double maxWeight;
    private Dimensions maxDimensions;
    private List<String> equipment; // GPS, refrigeration, etc.
}

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Driver {
    private String name;
    private String licenseNumber;
    private String phone;
    private String email;
    private List<String> certifications;
}

public enum FleetStatus {
    AVAILABLE, ASSIGNED, IN_TRANSIT, MAINTENANCE, OFFLINE
}
