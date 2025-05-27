package com.vm.smartvin.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Column;
import lombok.Data;

@Data
@Entity
public class CarDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_details_seq")
    @SequenceGenerator(name = "car_details_seq", sequenceName = "car_details_sequence", allocationSize = 1)
    private Long id;
    private String vin;
    private String make;
    private String model;

    @Column(name = "manufacture_year")
    private int manufactureYear;

    private String color;

    @JsonProperty("product_type")
    private String productType;

    private String body;
    private String series;

    @JsonProperty("fuel_type")
    private String fuelType;

    private String gears;

    @JsonProperty("emission_standard")
    private String emissionStandard;

    private String manufacturer;

    @JsonProperty("manufacturer_address")
    private String manufacturerAddress;

    @JsonProperty("plant_country")
    private String plantCountry;

    @JsonProperty("engine_manufacturer")
    private String engineManufacturer;

    @JsonProperty("avg_co2_emission_g_km")
    private String avgCo2EmissionGkm;

    @JsonProperty("no_of_axels")
    private String noOfAxels;

    @JsonProperty("no_of_doors")
    private String noOfDoors;

    @JsonProperty("no_of_seats")
    private String noOfSeats;

    @JsonProperty("rear_brakes")
    private String rearBrakes;

    @JsonProperty("steering_type")
    private String steeringType;

    @JsonProperty("rear_suspension")
    private String rearSuspension;

    @JsonProperty("front_suspension")
    private String frontSuspension;

    @JsonProperty("wheel_size")
    private String wheelSize;

    @JsonProperty("wheel_size_array")
    private String wheelSizeArray;

    @JsonProperty("wheelbase_mm")
    private String wheelbaseMm;

    @JsonProperty("wheelbase_array_mm")
    private String wheelbaseArrayMm;

    @JsonProperty("height_mm")
    private String heightMm;

    @JsonProperty("length_mm")
    private String lengthMm;

    @JsonProperty("width_mm")
    private String widthMm;

    @JsonProperty("track_front_mm")
    private String trackFrontMm;

    @JsonProperty("track_rear_mm")
    private String trackRearMm;

    @JsonProperty("max_speed_kmh")
    private String maxSpeedKmh;

    @JsonProperty("max_trunk_capacity_liters")
    private String maxTrunkCapacityLiters;

    @JsonProperty("min_trunk_capacity_liters")
    private String minTrunkCapacityLiters;

    @JsonProperty("weight_empty_kg")
    private String weightEmptyKg;

    @JsonProperty("max_weight_kg")
    private String maxWeightKg;

    @JsonProperty("max_roof_load_kg")
    private String maxRoofLoadKg;

    @JsonProperty("permitted_trailer_load_without_brakes_kg")
    private String permittedTrailerLoadWithoutBrakesKg;

    private String abs;

    @JsonProperty("check_digit")
    private String checkDigit;

    @JsonProperty("sequential_number")
    private String sequentialNumber;

    private String imageUrl;
}
