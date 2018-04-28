package com.flocondria.fridge.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.flocondria.fridge.domain.Product;

/**
 * DataSource Management for the Products of a Storage Unit.
 * <p>
 * Created by Lætitia.
 */
public interface ProductRepository extends CrudRepository<Product, UUID> {
	Optional<Product> findByName(String name);
}