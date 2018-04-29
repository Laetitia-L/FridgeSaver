package com.flocondria.fridge.authentification.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flocondria.fridge.authentification.domain.User;

public interface UserRepository extends JpaRepository<User, UUID> {
	User findByUsername(String username);
}
