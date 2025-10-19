package com.freightportal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
