package com.flocondria.fridge.repository;

import com.linkazer.flocondria.uuid.UuidHelper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.flocondria.fridge.domain.Product;

import java.util.Optional;
import java.util.UUID;

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
	
	@Test
	@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "/beforeTestRun.sql")
	public void findById() {
		UUID              uuid     = UuidHelper.getUUIDFromHexString("583f798750d64ba186c5187349ee7681");
		Optional<Product> optional = productRepository.findById(uuid);
		Assert.assertTrue(optional.isPresent());
	}
}
