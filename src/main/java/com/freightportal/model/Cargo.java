package com.freightportal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
