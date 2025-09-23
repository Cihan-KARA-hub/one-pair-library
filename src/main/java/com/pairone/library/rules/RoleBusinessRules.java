package com.pairone.library.rules;

import com.pairone.library.core.exception.type.BusinessException;
import com.pairone.library.entity.Role;
import com.pairone.library.entity.enums.RoleType;
import com.pairone.library.repository.RoleRepository;
import org.springframework.stereotype.Component;

@Component
public class RoleBusinessRules {

    private final RoleRepository roleRepository;

    public RoleBusinessRules(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    // Kural 1: Role type benzersiz olmalı
    public void checkIfRoleTypeExists(RoleType type) {
        roleRepository.findByType(type).ifPresent(r -> {
            throw new BusinessException("This role already exists: " + type);
        });
    }
    public Role getRole(RoleType type) {
        return roleRepository.findByType(type).orElseThrow(()-> new BusinessException("This role does not exist: " + type));
    }
}
