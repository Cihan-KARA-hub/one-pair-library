package com.pairone.library.dto.role;

import com.pairone.library.entity.enums.RoleType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RoleRequest {
    @NotNull
    private RoleType type;


    public @NotBlank RoleType getType() {
        return type;
    }

    public void setType(@NotBlank RoleType type) {
        this.type = type;
    }
}
