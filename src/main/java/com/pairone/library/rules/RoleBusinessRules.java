package com.pairone.library.rules;

import com.pairone.library.repository.RoleRepository;
import org.springframework.stereotype.Component;

@Component
public class RoleBusinessRules {

    private final RoleRepository roleRepository;

    public RoleBusinessRules(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    // Kural 1: Role type benzersiz olmalı
    public void checkIfRoleTypeExists(String type) {
        roleRepository.findByType(type).ifPresent(r -> {
            throw new IllegalArgumentException("Bu role zaten mevcut: " + type);
        });
    }
}
