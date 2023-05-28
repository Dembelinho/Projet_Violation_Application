package com.sdia.radarapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vehicle {

    private String registrationNumber;
    private String brand;
    private int model;
    private double fiscalPower;
    private Owner owner;
}
