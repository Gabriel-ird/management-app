package com.example.management_app.dto;

import java.util.UUID;

public record CarDto(UUID id,
                     String make,
                     String model,
                     int year,
                     String price
) {

}
