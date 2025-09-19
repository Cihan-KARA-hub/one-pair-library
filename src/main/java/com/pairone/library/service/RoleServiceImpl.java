package com.pairone.library.service;
import com.pairone.library.entity.Role;
import com.pairone.library.dto.role.RoleRequest;
import com.pairone.library.dto.role.RoleResponse;
import com.pairone.library.entity.enums.RoleType;
import com.pairone.library.repository.RoleRepository;
import com.pairone.library.rules.RoleBusinessRules;
import com.pairone.library.service.abstractservice.RoleService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleBusinessRules roleBusinessRules;

    public RoleServiceImpl(RoleRepository roleRepository, RoleBusinessRules roleBusinessRules) {
        this.roleRepository = roleRepository;
        this.roleBusinessRules = roleBusinessRules;
    }

    @Override
    public RoleResponse createRole(RoleRequest request) {
        // Business rules çağrılıyor
        roleBusinessRules.checkIfRoleTypeExists(request.getType());

        Role role = new Role();
        role.setType(request.getType());
        Role saved = roleRepository.save(role);

        return mapToResponse(saved);
    }

    @Override
    public RoleResponse updateRole(Integer id, RoleRequest request) {
        Role role = roleRepository.findById(id).orElseThrow();

        RoleType newType = request.getType();
        if (!role.getType().equals(newType)) {
            roleBusinessRules.checkIfRoleTypeExists(newType);
        }

        role.setType(newType);
        return mapToResponse(roleRepository.save(role));
    }

    @Override
    public void deleteRole(Integer id) {
        roleRepository.deleteById(id);
    }

    @Override
    public RoleResponse getRoleById(Integer id) {
        return roleRepository.findById(id).map(this::mapToResponse).orElse(null);
    }

    @Override
    public List<RoleResponse> getAllRoles() {
        return roleRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private RoleResponse mapToResponse(Role role) {
        RoleResponse response = new RoleResponse();
        response.setRoleId(role.getRoleId());
        response.setType(role.getType().name());
        return response;
    }
}
