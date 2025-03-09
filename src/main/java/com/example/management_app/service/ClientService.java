package com.example.management_app.service;

import com.example.management_app.dto.ClientDto;
import com.example.management_app.mapper.ObjectMapper;
import com.example.management_app.persistence.entity.Client;
import com.example.management_app.persistence.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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


}
