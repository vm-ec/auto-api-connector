package com.vm.smartvin.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarInfoResponse {
    private boolean success;
    private Input input;
    private Attributes attributes;
    private String timestamp;
}
