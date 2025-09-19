package com.pairone.library.dto.role;

import com.pairone.library.entity.enums.RoleType;
import jakarta.validation.constraints.NotBlank;

public class RoleRequest {
    @NotBlank
    private RoleType type;


    public @NotBlank RoleType getType() {
        return type;
    }

    public void setType(@NotBlank RoleType type) {
        this.type = type;
    }
}
