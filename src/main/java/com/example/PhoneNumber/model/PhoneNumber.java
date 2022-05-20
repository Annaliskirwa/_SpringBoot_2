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
        if (phoneNumber.matches("[0-9]+")){
            return phoneNumber;
        }else{
            phoneNumber = phoneNumber.replaceAll("\\D+","");
        }
        if (phoneNumber.equals("")){
            return "";
        }
        if (phoneNumber.length() == 9 & phoneNumber.startsWith("7")){
            String p = "+254-" + phoneNumber;
            return p;
        }
        if (phoneNumber.length() == 10 & phoneNumber.startsWith("0")){
            String p = phoneNumber.replaceFirst("^0","+254-");
            return p;
        }

        if (phoneNumber.length() == 12 && phoneNumber.startsWith("254")){
            String p = phoneNumber.replaceFirst("^254", "+254-");
            return p;
        }
        if (phoneNumber.length() == 13 && phoneNumber.startsWith("+254")){
            String p = phoneNumber.replaceFirst("^+254","+254-");
            return p;
        }
        if (phoneNumber.length() == 11){
            String p = phoneNumber.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "+($1) $2-$3");
            return p;
        }
        return phoneNumber;
    }
}
