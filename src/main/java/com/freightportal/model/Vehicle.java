package com.freightportal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
