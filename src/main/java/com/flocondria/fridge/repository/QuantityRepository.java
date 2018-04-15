package com.flocondria.fridge.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.flocondria.fridge.domain.Quantity;


public interface QuantityRepository extends CrudRepository<Quantity, UUID> {

}
