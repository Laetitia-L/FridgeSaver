package com.flocondria.fridge.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flocondria.fridge.domain.StorageUnit;
import com.flocondria.fridge.repository.StorageUnitRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
public class StorageUnitControllerTest {
	
	private MockMvc mockStorage;
	
	@Autowired
	private StorageUnitController storageUnitController;
	
	@Autowired
	private StorageUnitRepository storageUnitRepository;
	
	@Before
	public void setup() {
		mockStorage = standaloneSetup(storageUnitController).build();
	}
	
	//Case 1 : EntityNotFoundException is thrown because we don't specify any Home entity
	@Test
	public void createStorageWithHomeNotFound() throws Exception {
		
		Map<String, Object> storageUnit = new HashMap<String, Object>();
		storageUnit.put("name", "Indesit");
		storageUnit.put("type", "Fridge");
		
		String jsonStorageUnit = (new ObjectMapper())
			   .writeValueAsString(storageUnit);
		
		this.mockStorage
			.perform(post("/addStorageUnit")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonStorageUnit))
			.andExpect(MockMvcResultMatchers.status().isNotFound());
		
		Optional<StorageUnit> optional = storageUnitRepository.findByName("Indesit");
		
		Assert.assertFalse(optional.isPresent());
	}
	
	//Case 2 : The storage unit is successfully created, the home exists
	@Test
	@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "/beforeTestRun.sql")
	@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "/afterTestRun.sql")
	public void createStorageSuccessfully() throws Exception {
		
		Map<String, Object> storageUnit = new HashMap<String, Object>();
		storageUnit.put("name", "Indesit");
		storageUnit.put("homeName", "Home Sweet Home");
		storageUnit.put("type", "Fridge");
		
		this.mockStorage
			.perform(post("/addStorageUnit")
				.contentType(MediaType.APPLICATION_JSON)
				.content(
					(new ObjectMapper()).writeValueAsString(storageUnit)
				))
			.andExpect(MockMvcResultMatchers.status().isCreated());
		
		Optional<StorageUnit> optional = storageUnitRepository.findByName("Indesit");
		
		Assert.assertTrue(optional.isPresent());
	}
}
