package com.flocondria.fridge.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flocondria.fridge.domain.Product;
import com.flocondria.fridge.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
public class ProductControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private ProductController productController;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Before
	public void setup() {
		mockMvc = standaloneSetup(productController).build();
	}
	
	@Test
	public void createProduct() throws Exception {
		
		Map<String, Object> product = new HashMap<String, Object>();
		product.put("brand", "Bjorg");
		product.put("name", "Crispy Chips");
		product.put("barcode", "3056780560");
		product.put("amount", 90);
		product.put("unity", "gramme");
		
		String jsonProduct = (new ObjectMapper())
			.writerWithDefaultPrettyPrinter()
			.writeValueAsString(product);
		
		this.mockMvc
			.perform(post("/addProduct")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonProduct))
			.andExpect(MockMvcResultMatchers.status().isCreated());
		
		Optional<Product> optional = productRepository.findByName("Crispy Chips");
		Assert.assertTrue(optional.isPresent());
		Product productStored = (Product) optional.get();
		
		// delta define the precision tolerance (variation) comparison between two double value
		Assert.assertEquals(90.0, productStored.getQuantity().getAmount(), 0);
		Assert.assertEquals("Bjorg", productStored.getBrand());
		Assert.assertEquals("Crispy Chips", productStored.getName());
		Assert.assertEquals("3056780560", productStored.getBarcode());
	}
}
