package com.flocondria.fridge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.flocondria.fridge.domain.Product;
import com.flocondria.fridge.repository.ProductRepository;

@SpringBootApplication
public class FridgeSaverApplication implements CommandLineRunner {
	@Autowired
	ProductRepository productRepository;
	
	public static void main(String[] args){
		SpringApplication.run(FridgeSaverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productRepository.save(new Product("Pain d'épices", "Bjorg"));
		productRepository.save(new Product("Riz basmati", "Taureau ailé"));
		productRepository.save(new Product("Chocolat 85%", "Lindt"));
		
	}
}
