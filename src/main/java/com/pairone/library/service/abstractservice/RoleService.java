package com.pairone.library.service.abstractservice;

import com.pairone.library.dto.role.RoleCreateRequest;
import com.pairone.library.dto.role.RoleResponse;

import java.util.List;

public interface RoleService {
    RoleResponse createRole(RoleCreateRequest request);
    RoleResponse updateRole(Integer id, RoleCreateRequest request);
    void deleteRole(Integer id);
    RoleResponse getRoleById(Integer id);
    List<RoleResponse> getAllRoles();
}
