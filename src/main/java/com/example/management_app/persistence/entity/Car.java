package com.example.management_app.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
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


    @ManyToMany(mappedBy = "wishlist")
    @JsonBackReference
    private List<Client> interestedClients = new ArrayList<>();
}
