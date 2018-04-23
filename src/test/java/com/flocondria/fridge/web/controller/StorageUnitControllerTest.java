package com.flocondria.fridge.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.flocondria.fridge.domain.StorageUnit;
import com.flocondria.fridge.domain.StorageUnitEnum;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StorageUnitControllerTest {
	
	private MockMvc mockStorage;
	
	@Autowired
	private StorageUnitController storageUnitController;
	
	@Before
    public void setup() {
		mockStorage = standaloneSetup(storageUnitController).build();
    }
	
	//Case 1 : EntityNotFoundException is thrown
	@Test
	public void CreateStorageWithHomeNotFound() throws Exception{
		this.mockStorage
        .perform(post("/addStorageUnit")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\n" +
                 " \"name\": \"Storage_name\",\n" +
                 " \"type\": \"Fridge\"\n" +
                 "}"))
        .andExpect(MockMvcResultMatchers.status().isNotFound())
;
	}
	
	
	//Case 2 : The storage unit is successfully created
	@Test
	public void CreateStorageSuccessfully() throws Exception{
		//TODO
	}
}
