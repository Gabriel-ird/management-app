package com.example.management_app.mapper.impl;

import com.example.management_app.dto.CarDto;
import com.example.management_app.mapper.ObjectMapper;
import com.example.management_app.persistence.entity.Car;
import org.springframework.stereotype.Component;

@Component("carMapper")
public class CarMapper implements ObjectMapper<CarDto, Car> {

    @Override
    public Car mapDtoToEntity(CarDto dto) {
        Car car = new Car();

        car.setMake(dto.make());
        car.setModel(dto.model());
        car.setYear(dto.year());
        car.setPrice(dto.price());

        return car;
    }

    @Override
    public CarDto mapEntityToDto(Car entity) {
        return new CarDto(
                entity.getId(),
                entity.getMake(),
                entity.getModel(),
                entity.getYear(),
                entity.getPrice()
        );
    }

}
