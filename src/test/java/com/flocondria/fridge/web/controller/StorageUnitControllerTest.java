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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.flocondria.fridge.domain.StorageUnit;
import com.flocondria.fridge.domain.StorageUnitEnum;

import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest
public class StorageUnitControllerTest {
	
	private MockMvc mockStorage;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private StorageUnitController storageUnitController;


	@Before
    public void setup() {
		mockStorage = standaloneSetup(storageUnitController).build();
    }
	@SqlGroup({
			@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "/beforeTestRun.sql"),
			@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "/afterTestRun.sql")
	})

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
	
	
	//Case 2 : The storage unit is successfully created, the home exists
	@Test
	@Sql ("/beforeTestRun.sql")
	public void CreateStorageSuccessfully() throws Exception{
		this.mockStorage
				.perform(post("/addStorageUnit")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\n" +
								" \"name\": \"Storage_name\",\n" +
								" \"homeName\": \"Home Sweet Home\",\n" +
								" \"type\": \"Fridge\"\n" +
								"}"))
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}


	@Test
	@Sql ("/beforeTestRun.sql")
	public void contextLoads() {

		String selectQuery = "SELECT * from HOME";

		List<Map<String, Object>> resultSet = jdbcTemplate
				.queryForList(selectQuery);

		System.out.println("////////////////////" + resultSet);
	}
}
