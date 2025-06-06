package com.vm.smartvin.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vm.smartvin.model.CarDetails;
import com.vm.smartvin.model.CarInfoResponse;
import com.vm.smartvin.model.VinImageResponse;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.net.URIBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class CarDetailsRestClient {
    @Value("${carEx.url}")
    private String carExUrl;
    @Value("${carEx.apiKey}")
    private String key;

    public CarInfoResponse fetchCarDetails(String vin) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            URIBuilder uriBuilder = new URIBuilder(carExUrl.concat("/specs"));
            uriBuilder.addParameter("vin", vin);
            uriBuilder.addParameter("key", key);
            HttpGet request = new HttpGet(uriBuilder.build());

            try (CloseableHttpResponse response = httpClient.execute(request)) {
                if (response.getCode() == 200) {
                    return parseResponse(EntityUtils.toString(response.getEntity()), CarInfoResponse.class);
                } else {
                    throw new RuntimeException("Failed to fetch car details. HTTP Code: " + response.getCode());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error while calling third-party API", e);
        }
    }

    public VinImageResponse fetchCarImageDetails(CarDetails carDetails) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            URIBuilder uriBuilder = new URIBuilder(carExUrl.concat("/images"));
            if (carDetails.getVin() != null) {
                uriBuilder.addParameter("vin", carDetails.getVin());
            }
            if (carDetails.getMake() != null) {
                uriBuilder.addParameter("make", carDetails.getMake());
            }
            if (carDetails.getModel() != null) {
                uriBuilder.addParameter("model", carDetails.getModel());
            }
            if (carDetails.getYear() != 0) {
                uriBuilder.addParameter("year", String.valueOf(carDetails.getYear()));
            }
            if (carDetails.getColor() != null) {
                uriBuilder.addParameter("color", carDetails.getColor());
            }
            uriBuilder.addParameter("key", key);

            HttpPost request = new HttpPost(uriBuilder.build());
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                if (response.getCode() == 200) {
                    String imageResponse = EntityUtils.toString(response.getEntity());
                    return parseResponse(imageResponse, VinImageResponse.class);
                } else {
                    throw new RuntimeException("Failed to fetch car image details. HTTP Code: " + response.getCode());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error while calling third-party API", e);
        }
    }

    private <T> T parseResponse(String responseBody, Class<T> responseType) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(responseBody, responseType);
        } catch (Exception e) {
            throw new RuntimeException("Error while parsing response", e);
        }
    }

    public String findCarMarketValue(String vin) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            URIBuilder uriBuilder = new URIBuilder(carExUrl.concat("/marketvalue"));
            uriBuilder.addParameter("vin", vin);
            uriBuilder.addParameter("key", key);
            HttpPost httpPost = new HttpPost(uriBuilder.build());
            try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                if (response.getCode() == 200) {
                    return EntityUtils.toString(response.getEntity());
                } else {
                    throw new RuntimeException("Failed to fetch market value. HTTP Code: " + response.getCode());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error while calling third-party API", e);
        }
    }

    public String findCarHistory(String vin){
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            URIBuilder uriBuilder = new URIBuilder(carExUrl.concat("/history"));
            uriBuilder.addParameter("vin", vin);
            uriBuilder.addParameter("key", key);
            HttpPost httpPost = new HttpPost(uriBuilder.build());
            try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                if (response.getCode() == 200) {
                    return EntityUtils.toString(response.getEntity());
                } else {
                    throw new RuntimeException("Failed to fetch market value. HTTP Code: " + response.getCode());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error while calling third-party API", e);
        }

    }
}
