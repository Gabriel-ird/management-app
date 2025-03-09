package com.example.management_app.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter

public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID id;

    private String make;
    private String model;
    private int year;
    private String price;
}
