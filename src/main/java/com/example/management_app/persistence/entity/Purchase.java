package com.example.management_app.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter

public class Purchase {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    @JsonBackReference
    private Client client;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    private LocalDate purchaseDate;
}
