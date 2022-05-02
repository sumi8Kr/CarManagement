package com.example.CarManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CarManagement.domain.Car;

@Repository
public interface CarRepository extends JpaRepository<Car,Long>{
    
}