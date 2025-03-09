package com.example.management_app.controller;

import com.example.management_app.dto.ClientDto;
import com.example.management_app.dto.PurchaseDto;
import com.example.management_app.persistence.entity.Purchase;
import com.example.management_app.service.PurchaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {
    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping
    public ResponseEntity<Purchase> createPurchase(@RequestBody PurchaseDto purchaseDto) {
        Purchase purchase = purchaseService.createPurchase(purchaseDto);
        return ResponseEntity.ok(purchase);
    }


}
