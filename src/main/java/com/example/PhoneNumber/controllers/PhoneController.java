package com.example.PhoneNumber.controllers;

import com.example.PhoneNumber.model.PhoneNumber;
import com.example.PhoneNumber.repository.PhoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;
import java.util.Objects;
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
    @GetMapping("/phonenumber/{id}")
    public Optional<PhoneNumber> getPhoneNumberById(@PathVariable(value = "id") Long phoneId){
        return phoneNumberRepository.findById(phoneId);
    }
    @DeleteMapping("/phonenumber/{id}")
    public String deletePhoneNumber(@PathVariable(value = "id") Long phoneId){
        phoneNumberRepository.deleteById(phoneId);
        return "The phone number has been deleted";
    }
    @PostMapping("/phonenumber")
    public PhoneNumber createPhoneNumber(@Valid @RequestBody PhoneNumber phoneNumber ){
        return phoneNumberRepository.save(phoneNumber);
    }
    @PutMapping("/phonenumber/{id}")
    public PhoneNumber updatePhoneNumber(@Valid @RequestBody PhoneNumber phoneNumber,@PathVariable(value = "id") Long phoneId){
        PhoneNumber phoneNumber1 = (PhoneNumber) phoneNumberRepository.findById(phoneId).get();
        if (Objects.nonNull(phoneNumber.getPhoneNumber())
        && !"".equalsIgnoreCase(phoneNumber.getPhoneNumber())){
            phoneNumber1.setPhoneNumber(phoneNumber.getPhoneNumber());
        }
        return (PhoneNumber) phoneNumberRepository.save(phoneNumber1);
    }

    public String sanitizePhoneNumber(String phoneNumber){
        if (phoneNumber.equals("")){
            return "";
        }
        if (phoneNumber.length() < 11 & phoneNumber.startsWith("0")){
            String p = phoneNumber.replaceFirst("^0","+254-");
            return p;
        }
        if (phoneNumber.length() == 13 && phoneNumber.startsWith("+254")){
            String p = phoneNumber.replaceFirst("^+254","+254-");
            return p;
        }
        if (phoneNumber.length() == 12 && phoneNumber.startsWith("254")){
            String p = phoneNumber.replaceFirst("^254", "+254-");
            return p;
        }
        return phoneNumber;
    }
}



