package com.vm.smartvin.service;

import com.vm.smartvin.client.CarDetailsRestClient;
import com.vm.smartvin.entity.CarDetailsEntity;
import com.vm.smartvin.model.CarDetails;
import com.vm.smartvin.model.CarDetailsResponse;
import com.vm.smartvin.model.CarInfoResponse;
import com.vm.smartvin.model.VinImageResponse;
import com.vm.smartvin.repository.CarDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarDetailsService {

    private final CarDetailsRestClient carDetailsRestClient;
    private final CarDetailsRepository carDetailsRepository;
    private final ObjectMapperUtil objectMapperUtil;


    public CarDetailsService(CarDetailsRestClient carDetailsRestClient, CarDetailsRepository carDetailsRepository,ObjectMapperUtil objectMapperUtil) {
        this.carDetailsRestClient = carDetailsRestClient;
        this.carDetailsRepository = carDetailsRepository;
        this.objectMapperUtil = objectMapperUtil;
    }

    public CarDetailsResponse getCarDetailsByVin(String vin) {
        // Call the REST client to fetch car details
        CarDetailsResponse carDetailsResponse = findCarInfoFromDB(vin);
        if(carDetailsResponse != null) {
            return carDetailsResponse;
        }

       CarInfoResponse carInfoResponse = carDetailsRestClient.fetchCarDetails(vin);
       if(carInfoResponse != null) {
           CarDetails carDetails = new CarDetails();
           carDetails.setVin(carInfoResponse.getInput().getVin());
           carDetails.setMake(carInfoResponse.getAttributes().getMake());
           carDetails.setModel(carInfoResponse.getAttributes().getModel());
         VinImageResponse imageResponse = carDetailsRestClient.fetchCarImageDetails(carDetails);
         //objectMapperUtil.map(carInfoResponse.getAttributes(),CarDetailsResponse.class);


         return CarDetailsResponse.builder().images(imageResponse.getImages()).attributes(carInfoResponse.getAttributes()).build();

       }
        return null;
    }

    public VinImageResponse getImageDetailsByVin(CarDetails carDetails) {
        // Call the REST client to fetch car image details
        return carDetailsRestClient.fetchCarImageDetails(carDetails);
    }

    private CarDetailsResponse findCarInfoFromDB(String vin) {
        CarDetailsEntity carDetailsEntity = carDetailsRepository.findByVin(vin);
        if(carDetailsEntity != null) {
            return objectMapperUtil.map(carDetailsEntity,CarDetailsResponse.class);
        }
        return null;
    }

    public String findMarketValue(String vin){
        return carDetailsRestClient.findCarMarketValue(vin);
    }
    public String findCarHistory(String vin){
        return carDetailsRestClient.findCarHistory(vin);
    }

}
