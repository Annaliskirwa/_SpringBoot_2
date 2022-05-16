package com.example.PhoneNumber.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PhoneRestTemplate {
    @Autowired
    RestTemplate restTemplate;
}
