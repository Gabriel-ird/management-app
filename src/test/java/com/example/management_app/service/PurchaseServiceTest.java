package com.example.management_app.service;

import com.example.management_app.persistence.entity.Purchase;
import com.example.management_app.persistence.repository.CarRepository;
import com.example.management_app.persistence.repository.ClientRepository;
import com.example.management_app.persistence.repository.PurchaseRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.mock;

public class PurchaseServiceTest {

    private PurchaseService purchaseService;
    private PurchaseRepository purchaseRepository;

    private ClientService clientService;
    private ClientRepository clientRepository;

    private CarService carService;
    private CarRepository carRepository;


    @BeforeEach
    void setUp() {
        purchaseRepository = mock(PurchaseRepository.class);
        clientRepository = mock(ClientRepository.class);
        carRepository = mock(CarRepository.class);

        purchaseService = new PurchaseService(
                              purchaseRepository,
                              clientRepository,
                              carRepository
        );
    }

    @Test
    public void testCreatePurchase() {
        Purchase purchase = new Purchase();

    }
}
