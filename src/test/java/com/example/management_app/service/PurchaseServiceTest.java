package com.example.management_app.service;


import com.example.management_app.dto.PurchaseDto;
import com.example.management_app.persistence.entity.Car;
import com.example.management_app.persistence.entity.Client;
import com.example.management_app.persistence.entity.Purchase;
import com.example.management_app.persistence.repository.CarRepository;
import com.example.management_app.persistence.repository.ClientRepository;
import com.example.management_app.persistence.repository.PurchaseRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PurchaseServiceTest {

    @Mock
    private PurchaseRepository purchaseRepository;

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private PurchaseService purchaseService;

    @Test
    @DisplayName("Test create purchase")
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    public void testCreatePurchase() {
        Long clientId = 1L;
        UUID carId = UUID.randomUUID();
        UUID purchaseId = UUID.randomUUID();

        PurchaseDto purchaseDto = new PurchaseDto();
        purchaseDto.setClientId(clientId);
        purchaseDto.setCarId(carId);

        Client mockClient = new Client();
        mockClient.setId(clientId);

        Car mockCar = new Car();
        mockCar.setId(carId);

        Purchase savedPurchase = new Purchase();
        savedPurchase.setId(purchaseId);

        when(clientRepository.findById(clientId)).thenReturn(Optional.of(mockClient));
        when(carRepository.findById(carId)).thenReturn(Optional.of(mockCar));
        when(purchaseRepository.save(any(Purchase.class))).thenReturn(savedPurchase);

        Purchase result = purchaseService.createPurchase(purchaseDto);

        assertNotNull(result);
        assertEquals(purchaseId, result.getId());
    }
}
