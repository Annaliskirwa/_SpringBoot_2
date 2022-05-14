package com.example.PhoneNumber.controller;

import com.example.PhoneNumber.model.PhoneNumber;
import com.example.PhoneNumber.repository.PhoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/phonenumber")
public class PhoneController {
    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    @GetMapping
    public List<PhoneNumber> getPhoneNumber(){
        return phoneNumberRepository.findAll();
    }

}
