package com.vm.smartvin.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CarDetailsResponse {
    private String vin;
    private Attributes attributes;
    private List<Image> images;
}
