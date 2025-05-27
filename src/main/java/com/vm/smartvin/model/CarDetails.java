package com.vm.smartvin.model;

import lombok.Data;

@Data
public class CarDetails {
    private String vin;
    private String make;
    private String model;
    private int year;
    private String color;


}
