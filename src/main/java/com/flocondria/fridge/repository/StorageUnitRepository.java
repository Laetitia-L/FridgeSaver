package com.flocondria.fridge.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.flocondria.fridge.domain.StorageUnit;

public interface StorageUnitRepository extends CrudRepository<StorageUnit, UUID>{

}
