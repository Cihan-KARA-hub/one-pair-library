package com.pairone.library.mapper;

import com.pairone.library.dto.address.request.AddressCreateRequest;
import com.pairone.library.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);


    Address AddressCreateRequestToAddress(AddressCreateRequest res);
}
