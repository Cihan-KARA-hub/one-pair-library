package com.pairone.library.repository;

import com.pairone.library.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Object> findByType(String type);
}
