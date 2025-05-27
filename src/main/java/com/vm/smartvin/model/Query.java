package com.vm.smartvin.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class Query {
    private String vin;
    private String make;
    private String model;
}
