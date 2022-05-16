package com.example.PhoneNumber.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpHeaders;
import java.util.Arrays;

@RestController
public class PhoneRestTemplate {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "template/phonenumber")
    public String getPhoneNumbers(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    }
}
