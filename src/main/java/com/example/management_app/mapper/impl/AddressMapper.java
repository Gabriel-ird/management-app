package com.example.management_app.mapper.impl;

import com.example.management_app.dto.ClientDto;
import com.example.management_app.mapper.ObjectMapper;
import com.example.management_app.persistence.entity.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper implements ObjectMapper<ClientDto.AddressDto, Address> {

    @Override
    public ClientDto.AddressDto mapEntityToDto(Address address) {
        return new ClientDto.AddressDto(
                address.getCity(),
                address.getStreet(),
                address.getNumber()
        );
    }

    @Override
    public Address mapDtoToEntity(ClientDto.AddressDto addressDto) {
        Address address = new Address();

        address.setCity(addressDto.getCity());
        address.setStreet(addressDto.getStreet());
        address.setNumber(addressDto.getNumber());
        return address;
    }
}
