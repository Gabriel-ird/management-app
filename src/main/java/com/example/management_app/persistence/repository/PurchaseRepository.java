package com.example.management_app.persistence.repository;

import com.example.management_app.persistence.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

public interface PurchaseRepository extends JpaRepository<Purchase, UUID> {
    ResponseEntity<Purchase> findById(PathVariable uuid);
}
