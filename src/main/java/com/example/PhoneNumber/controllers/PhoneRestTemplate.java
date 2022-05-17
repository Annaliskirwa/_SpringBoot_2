package com.example.PhoneNumber.controllers;

import com.example.PhoneNumber.model.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
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

    @RequestMapping(value = "template/phonenumber/{id}", method = RequestMethod.PUT)
    public String updatePhoneNumbers(@PathVariable(value = "id") String id, @RequestBody @Valid PhoneNumber phoneNumber){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<PhoneNumber> entity = new HttpEntity<PhoneNumber>(phoneNumber, headers);

        return restTemplate.exchange("http://localhost:8080/phonenumber/v1/phonenumber/"+id, HttpMethod.PUT, entity, String.class).getBody();

    }
    @RequestMapping(value = "template/phonenumber/{id}")
    public String deletePhoneNumbers(@PathVariable(value = "id") String id){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<PhoneNumber> entity = new HttpEntity<PhoneNumber>(headers);

        return restTemplate.exchange("http://localhost:8080/phonenumber/v1/phonenumber/"+id, HttpMethod.DELETE, entity, String.class).getBody();
    }
    @RequestMapping(value = "template/phonenumber/{id}", method = RequestMethod.GET)
    public String getPhoneByPhoneId(@PathVariable(value = "id") String id){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<PhoneNumber> entity = new HttpEntity<PhoneNumber>(headers);

        return restTemplate.exchange("http://localhost:8080/phonenumber/v1/phonenumber/"+id, HttpMethod.GET, entity, String.class).getBody();

    }

}
