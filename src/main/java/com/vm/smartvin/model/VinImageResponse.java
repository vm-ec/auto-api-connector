package com.vm.smartvin.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class VinImageResponse {
    private Query query;
    private List<Image> images;
}
