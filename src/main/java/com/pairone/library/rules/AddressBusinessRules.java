package com.pairone.library.rules;

import org.springframework.stereotype.Component;

@Component
public class AddressBusinessRules {

    public void checkCityAndDistrict(String city, String district) {
        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException("Şehir boş olamaz");
        }
        if (district == null || district.isBlank()) {
            throw new IllegalArgumentException("İlçe boş olamaz");
        }
    }
}
