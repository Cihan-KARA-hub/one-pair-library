package com.pairone.library.rules;

import com.pairone.library.core.exception.type.BusinessException;
import org.springframework.stereotype.Component;

@Component
public class AddressBusinessRules {

    public void checkCityAndDistrict(String city, String district) {
        if (city == null || city.isBlank()) {
            throw new BusinessException("Şehir boş olamaz");
        }
        if (district == null || district.isBlank()) {
            throw new BusinessException("İlçe boş olamaz");
        }
    }
}
