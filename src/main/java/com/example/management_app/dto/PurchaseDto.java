package com.example.management_app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class PurchaseDto {
    private Long clientId;
    private UUID carId;

    public PurchaseDto() {

    }
}
