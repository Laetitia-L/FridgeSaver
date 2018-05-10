package com.flocondria.fridge.security.repository;

import com.flocondria.fridge.security.model.Role;
import com.flocondria.fridge.security.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
