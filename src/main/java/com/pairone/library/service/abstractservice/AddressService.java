package com.pairone.library.service.abstractservice;

import java.util.List;
import com.pairone.library.dto.address.request.AddressCreateRequest;
import com.pairone.library.dto.address.response.AddressResponse;

public interface AddressService {
    AddressResponse createAddress(AddressCreateRequest request);
    AddressResponse updateAddress(Integer id, AddressCreateRequest request);
    void deleteAddress(Integer id);
    AddressResponse getAddressById(Integer id);
    List<AddressResponse> getAllAddresses();
}
