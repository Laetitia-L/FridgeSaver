package com.flocondria.fridge.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.flocondria.fridge.domain.Product;

/**
 * Demonstrate Creation, Reading, Updating, and Deletion of Products with
 * ProductRepository
 * <p>
 * Created by Lætitia
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTest {
	@Autowired
	ProductRepository productRepository;

	@Test
	public void createAndDeleteProduct() {
		productRepository.save(new Product("Pain d'épices", "Bjorg"));
		productRepository.save(new Product("Riz basmati", "Taureau ailé"));
		productRepository.save(new Product("Chocolat 85%", "Lindt"));

		System.out.println("\n************* Original Products *************");
		productRepository.findAll().forEach(product -> {
			System.out.println(product.getName());
            product.setBrand(product.getBrand().toUpperCase());
            productRepository.save(product);
		});

		productRepository.deleteAll();
		System.out.println("\n************* Products removed ? *************");
		productRepository.findAll().forEach(System.out::println);

	}
}
