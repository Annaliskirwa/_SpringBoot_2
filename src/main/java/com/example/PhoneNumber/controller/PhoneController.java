package com.example.PhoneNumber.controller;

import com.example.PhoneNumber.model.PhoneNumber;
import com.example.PhoneNumber.repository.PhoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/phonenumber/v1")
public class PhoneController {
    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    @GetMapping("/phonenumber")
    public List<PhoneNumber> getPhoneNumber(){
        return phoneNumberRepository.findAll();
    }
    @GetMapping("/phonenumber/{{id}}")
    public Optional<PhoneNumber> getPhoneNumberById(@PathVariable(value = "id") Long phoneId){
        return phoneNumberRepository.findById(phoneId);
    }
    @DeleteMapping("/phonenumber/{{id}}")
    public String deletePhoneNumber(@PathVariable(value = "id") Long phoneId){
        phoneNumberRepository.deleteById(phoneId);
        return "The phone number has been deleted";
    }

}
