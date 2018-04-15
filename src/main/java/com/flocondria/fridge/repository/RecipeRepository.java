package com.flocondria.fridge.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.flocondria.fridge.domain.Recipe;

/**
 * DataSource Management for the Recipes possible with the available Products.
 * <p>
 * Created by Lætitia.
 */
public interface RecipeRepository extends CrudRepository<Recipe, UUID> {
}