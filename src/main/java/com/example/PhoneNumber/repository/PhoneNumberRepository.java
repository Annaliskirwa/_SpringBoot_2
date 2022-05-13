package com.example.PhoneNumber.repository;

import com.example.PhoneNumber.model.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber,Long>{
}
