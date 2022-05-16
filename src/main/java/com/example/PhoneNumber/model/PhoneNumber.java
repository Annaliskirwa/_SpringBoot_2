package com.example.PhoneNumber.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "phoneNumber")
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long phoneId;

    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;

    public PhoneNumber(){

    }

    public PhoneNumber(Long phoneId, String phoneNumber) {
        this.phoneId = phoneId;
        this.phoneNumber = phoneNumber;
    }

    public Long getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Long phoneId) {
        this.phoneId = phoneId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = sanitizePhoneNumber(phoneNumber);
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
