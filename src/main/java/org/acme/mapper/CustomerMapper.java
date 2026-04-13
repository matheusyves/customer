package org.acme.mapper;

import org.acme.dto.CustomerDTO;
import org.acme.entity.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface CustomerMapper {

    CustomerDTO toDTO(CustomerEntity entity);

    CustomerEntity toEntity(CustomerDTO dto);
}