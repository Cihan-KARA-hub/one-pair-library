package com.pairone.library.controller;

import com.pairone.library.dto.address.request.AddressCreateRequest;
import com.pairone.library.dto.address.response.AddressResponse;
import com.pairone.library.service.abstractservice.AddressService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public AddressResponse create(@Valid @RequestBody AddressCreateRequest request) {
        return addressService.createAddress(request);
    }

    @PutMapping("/{id}")
    public AddressResponse update(@PathVariable Integer id, @Valid @RequestBody AddressCreateRequest request) {
        return addressService.updateAddress(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        addressService.deleteAddress(id);
    }

    @GetMapping("/{id}")
    public AddressResponse getById(@PathVariable Integer id) {
        return addressService.getAddressById(id);
    }

    @GetMapping
    public List<AddressResponse> getAll() {
        return addressService.getAllAddresses();
    }
}
