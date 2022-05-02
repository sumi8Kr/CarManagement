package com.example.CarManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CarManagement.domain.Car;
import com.example.CarManagement.repository.CarRepository;

@Service
public class CarService {
    @Autowired
    private CarRepository repo;
    public List<Car> listAll(){
        return repo.findAll();
    }

    public void save(Car car){
        repo.save(car);
    }

    public Car get(Long carId){
        return repo.findById(carId).get();
    }
    public void delete(Long carId){
        repo.deleteById(carId);
    }
}