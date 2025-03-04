package com.example.management_app.service;

import com.example.management_app.persistence.entity.Car;
import com.example.management_app.persistence.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car getCarById(UUID id) {
    return carRepository.findById(id).orElseThrow();
    }

    public List<Car> getCar() {
        return carRepository.findAll();
    }

    public Car createCar(Car car) {
        return carRepository.save(car);
    }
}
