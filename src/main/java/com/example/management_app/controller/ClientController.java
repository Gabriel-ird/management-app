package com.example.management_app.controller;

import com.example.management_app.dto.CarDto;
import com.example.management_app.dto.ClientDto;
import com.example.management_app.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<ClientDto> createClient(@RequestBody ClientDto client) {
        return new ResponseEntity<>(clientService.createClient(client), HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<ClientDto>> getClients() {
        return ResponseEntity.ok(clientService.getClients());
    }


    @PostMapping("/{clientId}/wishlist/{carId}")
    public ResponseEntity<String> addCarToWishlist(@PathVariable Long clientId, @PathVariable UUID carId) {
        clientService.addCarToWishlist(clientId, carId);
        return ResponseEntity.ok("Car added to wishlist!");
    }

    @GetMapping("/{clientId}/wishlist")
    public ResponseEntity<List<CarDto>> getWishlist(@PathVariable Long clientId) {
        List<CarDto> wishlist = clientService.getWishlist(clientId);
        return ResponseEntity.ok(wishlist);
    }

}
