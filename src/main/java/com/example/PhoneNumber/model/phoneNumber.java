package com.example.PhoneNumber.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "phoneNumber")
public class phoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String phoneNumber;
}
