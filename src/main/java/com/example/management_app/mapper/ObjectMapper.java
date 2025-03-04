package com.example.management_app.mapper;

public interface ObjectMapper<D, E> {

    E mapDtoToEntity(D dto);

    D mapEntityToDto(E entity);
}
