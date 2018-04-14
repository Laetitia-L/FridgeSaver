package repository;

import org.springframework.data.repository.CrudRepository;

import domain.Recipe;

/**
 * DataSource Management for the Recipes possible with the available Products.
 * <p>
 * Created by Lætitia.
 */
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
}