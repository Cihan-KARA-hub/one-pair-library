package com.pairone.library.service.abstractservice;

import java.util.List;
import com.pairone.library.dto.address.AddressRequest;
import com.pairone.library.dto.address.AddressResponse;

public interface AddressService {
    AddressResponse createAddress(AddressRequest request);
    AddressResponse updateAddress(Integer id, AddressRequest request);
    void deleteAddress(Integer id);
    AddressResponse getAddressById(Integer id);
    List<AddressResponse> getAllAddresses();
}
