package com.flocondria.fridge.repository;

import org.springframework.data.repository.CrudRepository;

import com.flocondria.fridge.domain.Product;

/**
 * DataSource Management for the Products of a Location.
 * <p>
 * Created by Lætitia.
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {
}