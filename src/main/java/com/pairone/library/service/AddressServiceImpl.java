package com.pairone.library.service;

import com.pairone.library.dto.address.request.AddressCreateRequest;
import com.pairone.library.dto.address.response.AddressResponse;
import com.pairone.library.entity.Address;
import com.pairone.library.repository.AddressRepository;
import com.pairone.library.rules.AddressBusinessRules;
import com.pairone.library.service.abstractservice.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressBusinessRules addressBusinessRules;

    public AddressServiceImpl(AddressRepository addressRepository,
                              AddressBusinessRules addressBusinessRules) {
        this.addressRepository = addressRepository;
        this.addressBusinessRules = addressBusinessRules;
    }

    @Override
    public AddressResponse createAddress(AddressCreateRequest request) {
        // Business rule kontrolü
        addressBusinessRules.checkCityAndDistrict(request.getCity(), request.getDistrict());

        Address address = new Address();
        address.setCity(request.getCity());
        address.setDistrict(request.getDistrict());
        address.setStreet(request.getStreet());
        address.setNeighborhood(request.getNeighborhood());
        address.setBuilding(request.getBuilding());
        address.setApartmentNo(request.getApartmentNo());

        Address saved = addressRepository.save(address);
        return mapToResponse(saved);
    }


    private AddressResponse mapToResponse(Address saved) {
        return null;
    }


    @Override
    public AddressResponse updateAddress(Integer id, AddressCreateRequest request) {
        return null;
    }

    @Override
    public void deleteAddress(Integer id) {

    }

    @Override
    public AddressResponse getAddressById(Integer id) {
        return null;
    }

    @Override
    public List<AddressResponse> getAllAddresses() {
        return List.of();
    }
}

