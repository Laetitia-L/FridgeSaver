package com.flocondria.fridge.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.flocondria.fridge.domain.Home;

public interface HomeRepository extends CrudRepository<Home, UUID>{

	Optional<Home> findByName(String homeName);
}
