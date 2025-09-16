package com.pairone.library.service.abstractservice;

import com.pairone.library.dto.role.RoleRequest;
import com.pairone.library.dto.role.RoleResponse;

import java.util.List;

public interface RoleService {
    RoleResponse createRole(RoleRequest request);
    RoleResponse updateRole(Integer id, RoleRequest request);
    void deleteRole(Integer id);
    RoleResponse getRoleById(Integer id);
    List<RoleResponse> getAllRoles();
}
