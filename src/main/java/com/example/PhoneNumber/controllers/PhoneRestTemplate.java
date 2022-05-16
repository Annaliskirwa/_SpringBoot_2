package com.example.PhoneNumber.controllers;

import com.example.PhoneNumber.model.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class PhoneRestTemplate {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "template/phonenumber")
    public String getPhoneNumbers(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity =  new HttpEntity<String>(headers);

        return restTemplate.exchange("http://localhost:8080/phonenumber/v1/phonenumber", HttpMethod.GET, entity, String.class).getBody();
    }

    @RequestMapping(value = "template/phonenumber", method = RequestMethod.POST)
    public String createPhoneNumbers(@RequestBody PhoneNumber phoneNumber){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<PhoneNumber> entity = new HttpEntity<PhoneNumber>(phoneNumber, headers);

        return restTemplate.exchange("http://localhost:8080/phonenumber/v1/phonenumber", HttpMethod.POST, entity, String.class).getBody();
    }
}
