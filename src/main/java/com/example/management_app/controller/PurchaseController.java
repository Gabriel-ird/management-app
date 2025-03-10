package com.example.management_app.controller;

import com.example.management_app.dto.ClientDto;
import com.example.management_app.dto.PurchaseDto;
import com.example.management_app.persistence.entity.Purchase;
import com.example.management_app.persistence.repository.PurchaseRepository;
import com.example.management_app.service.PurchaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {
    private final PurchaseService purchaseService;
    private final PurchaseRepository purchaseRepository;

    public PurchaseController(PurchaseService purchaseService, PurchaseRepository purchaseRepository) {
        this.purchaseService = purchaseService;
        this.purchaseRepository = purchaseRepository;
    }

    @PostMapping
    public ResponseEntity<Purchase> createPurchase(@RequestBody PurchaseDto purchaseDto) {
        Purchase purchase = purchaseService.createPurchase(purchaseDto);
        return ResponseEntity.ok(purchase);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Purchase> getPurchaseById(@PathVariable UUID id) {
        return purchaseRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Purchase>> getAllPurchases() {
        List<Purchase> purchases = purchaseRepository.findAll();
        if (purchases.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(purchases);
    }
}
