package com.example.management_app.controller;


import com.example.management_app.dto.CarDto;
import com.example.management_app.mapper.ObjectMapper;
import com.example.management_app.persistence.entity.Car;
import com.example.management_app.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;
    private final ObjectMapper<CarDto, Car> carMapper;

    public CarController(CarService carService,
                         ObjectMapper<CarDto, Car> carMapper) {
        this.carService = carService;
        this.carMapper = carMapper;
    }

    @GetMapping
    public ResponseEntity<List<CarDto>> getCar() {
        List<Car> cars = carService.getCar();
        return ResponseEntity.ok(
                cars.stream()
                        .map(carMapper::mapEntityToDto)
                        .toList()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDto> getCarById(@PathVariable UUID id) {
        Car carById = carService.getCarById(id);
        return ResponseEntity.ok(carMapper.mapEntityToDto(carById));

    }

    @PostMapping
    public ResponseEntity<CarDto> createCar(@RequestBody CarDto carDto) {
        Car mappedCar = carMapper.mapDtoToEntity(carDto);
        Car createdCar = carService.createCar(mappedCar);
        return new ResponseEntity<>(
                carMapper.mapEntityToDto(createdCar),
                HttpStatus.CREATED
        );
    }
    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable UUID id) {
        carService.deleteCarById(id);
    }
}
