package com.flocondria.fridge.authentification.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flocondria.fridge.authentification.domain.Role;

public interface RoleRepository extends JpaRepository<Role, UUID>{

}
