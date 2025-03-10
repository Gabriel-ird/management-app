package com.example.management_app.service;

import com.example.management_app.dto.CarDto;
import com.example.management_app.dto.ClientDto;
import com.example.management_app.mapper.ObjectMapper;
import com.example.management_app.persistence.entity.Car;
import com.example.management_app.persistence.entity.Client;
import com.example.management_app.persistence.repository.CarRepository;
import com.example.management_app.persistence.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ObjectMapper<ClientDto, Client> clientMapper;

    public ClientService(ClientRepository clientRepository,
                         ObjectMapper<ClientDto, Client> clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    public ClientDto createClient(ClientDto client) {
        Client entity = clientMapper.mapDtoToEntity(client);


        return clientMapper.mapEntityToDto(clientRepository.save(entity));

    }

    public List<ClientDto> getClients() {
        return clientRepository.findAll().stream()
                .map(clientMapper::mapEntityToDto)
                .toList();
    }

    @Autowired
    private CarRepository carRepository;

    public void addCarToWishlist(Long clientId, UUID carId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new RuntimeException("Car not found"));

        client.getWishlist().add(car);
        clientRepository.save(client);
    }

    public List<CarDto> getWishlist(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        return client.getWishlist().stream()
                .map(car -> new CarDto(car.getId(), car.getMake(), car.getModel(), car.getYear(), car.getPrice()))
                .collect(Collectors.toList());
    }


}
