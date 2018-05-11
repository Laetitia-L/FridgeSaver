package com.flocondria.fridge.auth.repository;

import com.flocondria.fridge.auth.model.Role;
import com.flocondria.fridge.auth.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
