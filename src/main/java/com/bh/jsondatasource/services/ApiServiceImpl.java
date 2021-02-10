package com.bh.jsondatasource.services;

import java.util.List;

import com.bh.jsondatasource.api.User;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiServiceImpl implements ApiService {
    @Autowired
    private RestTemplate restTemplate;

    // inject value from application.properties
    @Value("${jsondatasource.api.url}")
    private String API_URL;
    //private static String API_URL = "http://localhost:8080/datasource/getusers";

    @Override
    public List<User> getUsers() {
        ResponseEntity<List<User>> responseEntity = restTemplate.exchange(API_URL, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<User>>() {
                });
        List<User> users = responseEntity.getBody();
        return users;
    }
}
