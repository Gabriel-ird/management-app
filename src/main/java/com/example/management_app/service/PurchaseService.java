package com.example.management_app.service;

import com.example.management_app.dto.PurchaseDto;
import com.example.management_app.persistence.entity.Car;
import com.example.management_app.persistence.entity.Client;
import com.example.management_app.persistence.entity.Purchase;
import com.example.management_app.persistence.repository.CarRepository;
import com.example.management_app.persistence.repository.ClientRepository;
import com.example.management_app.persistence.repository.PurchaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final ClientRepository clientRepository;
    private final CarRepository carRepository;

    public PurchaseService(PurchaseRepository purchaseRepository, ClientRepository clientRepository, CarRepository carRepository) {
        this.purchaseRepository = purchaseRepository;
        this.clientRepository = clientRepository;
        this.carRepository = carRepository;
    }
    @Transactional
    public Purchase createPurchase(PurchaseDto purchaseDto) {
        Client client = clientRepository.findById(purchaseDto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));
        Car car = carRepository.findById(purchaseDto.getCarId())
                .orElseThrow(() -> new RuntimeException("Car not found"));

        Purchase purchase = new Purchase();
        purchase.setClient(client);
        purchase.setCar(car);
        purchase.setPurchaseDate(LocalDate.now());

        return purchaseRepository.save(purchase);
    }

}
