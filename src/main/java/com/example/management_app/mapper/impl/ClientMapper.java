package com.example.management_app.mapper.impl;

import com.example.management_app.dto.ClientDto;
import com.example.management_app.mapper.ObjectMapper;
import com.example.management_app.persistence.entity.Address;
import com.example.management_app.persistence.entity.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper implements ObjectMapper<ClientDto, Client> {

    private final ObjectMapper<ClientDto.AddressDto, Address> addressMapper;

    public ClientMapper(ObjectMapper<ClientDto.AddressDto, Address> addressMapper) {
        this.addressMapper = addressMapper;
    }

    @Override
    public ClientDto mapEntityToDto(Client client) {
        return new ClientDto(
                client.getId(),
                client.getName(),
                addressMapper.mapEntityToDto(client.getAddress())
        );
    }

    @Override
    public Client mapDtoToEntity(ClientDto clientDto) {
        Client client = new Client();

        client.setName(clientDto.getName());
        client.setAddress(addressMapper.mapDtoToEntity(clientDto.getAddress()));

        return client;
    }
}
