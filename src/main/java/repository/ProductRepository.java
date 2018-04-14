package repository;

import org.springframework.data.repository.CrudRepository;

import domain.Product;

/**
 * DataSource Management for the Products of a Location.
 * <p>
 * Created by Lætitia.
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {
}