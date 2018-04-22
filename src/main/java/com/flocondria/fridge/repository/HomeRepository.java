package com.flocondria.fridge.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.flocondria.fridge.domain.Home;

public interface HomeRepository extends CrudRepository<Home, UUID>{

}
