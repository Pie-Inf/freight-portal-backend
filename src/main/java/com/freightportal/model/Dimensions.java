package com.freightportal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dimensions {
    private double length;
    private double width;
    private double height;
    private String unit = "ft";
}
