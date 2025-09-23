package com.pairone.library.rules;

import com.pairone.library.core.exception.type.BusinessException;
import com.pairone.library.dto.address.request.AddressCreateRequest;
import com.pairone.library.entity.Address;
import com.pairone.library.mapper.AddressMapper;
import org.springframework.stereotype.Component;

@Component
public class AddressBusinessRules {
    private final AddressMapper addressMapper;

    public AddressBusinessRules(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    public void checkCityAndDistrict(String city, String district) {
        if (city == null || city.isBlank()) {
            throw new BusinessException("The city cannot be empty");
        }
        if (district == null || district.isBlank()) {
            throw new BusinessException("The district cannot be empty");
        }
    }
    public Address addressCreateRequestMapToEntity(AddressCreateRequest res){
        checkCityAndDistrict(res.getCity(), res.getDistrict());
        return addressMapper.AddressCreateRequestToAddress(res);

    }
}
