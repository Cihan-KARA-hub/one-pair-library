package com.pairone.library.controller;

import com.pairone.library.dto.role.RoleRequest;
import com.pairone.library.dto.role.RoleResponse;
import com.pairone.library.service.abstractservice.RoleService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public RoleResponse create(@Valid @RequestBody RoleRequest request) {
        return roleService.createRole(request);
    }

    @PutMapping("/{id}")
    public RoleResponse update(@PathVariable Integer id, @Valid @RequestBody RoleRequest request) {
        return roleService.updateRole(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        roleService.deleteRole(id);
    }

    @GetMapping("/{id}")
    public RoleResponse getById(@PathVariable Integer id) {
        return roleService.getRoleById(id);
    }

    @GetMapping
    public List<RoleResponse> getAll() {
        return roleService.getAllRoles();
    }
}
