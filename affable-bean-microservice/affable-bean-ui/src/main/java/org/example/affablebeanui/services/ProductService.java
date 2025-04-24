package org.example.affablebeanui.services;

import org.apache.commons.lang3.RandomStringUtils;
import org.example.affablebeanui.dto.OrderDetailDto;
import org.example.affablebeanui.dto.ProductDto;
import org.example.affablebeanui.dto.RequestDataDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class ProductService {

    private RestClient restClient;

    public ProductService() {
        restClient = RestClient.builder()
                .baseUrl("http://localhost:8080/api/affableBean")
                .build();
    }

    public List<ProductDto> getAllProducts() {
        return restClient.get()
                .uri("/all")
                .retrieve()
                .body(new ParameterizedTypeReference<List<ProductDto>>(){});
    }

    public List<ProductDto> getProductsByCategoryID(Integer categoryId) {
        restClient = RestClient.builder()
                .baseUrl("http://localhost:8080/api/affableBean")
                .build();
        return restClient.get()
                .uri("/category/{id}", categoryId)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }

    public void buyTransaction(RequestDataDto requestDataDto) {
        this.restClient = RestClient.builder()
                .baseUrl("http://localhost:8080/api/payment")
                .build();
        restClient.post()
                .uri("/buy-transaction")
                .contentType(MediaType.APPLICATION_JSON)
                .body(requestDataDto)
                .retrieve()
                .body(String.class);
    }

    public void saveProductOrderToBackend(OrderDetailDto orderDetailDto) {
        this.restClient = RestClient.builder()
                .baseUrl("http://localhost:8080/api/affableBean")
                .build();
        restClient.post()
                .uri("/save-order")
                .contentType(MediaType.APPLICATION_JSON)
                .body(orderDetailDto)
                .retrieve()
                .body(String.class);
    }

    public static String generateRandomNumber() {
        int desiredDigit = 15;
        return RandomStringUtils.randomNumeric(desiredDigit);
    }
}
