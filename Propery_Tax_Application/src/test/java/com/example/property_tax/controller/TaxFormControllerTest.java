package com.example.property_tax.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.property_tax.services.TaxFormService;

@WebMvcTest(PropertyTaxController.class)
public class TaxFormControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TaxFormService businessService;
	
	@Test
	public void dummyItem_basic() throws Exception {
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/getuav")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"id\": 1,\"description_id\":\"1\",\"status_id\":1,\"status_id\":1,\"uav\":2.50}"))
				.andReturn();
		
		
	}

	@Test
	public void retrieveAllItems_noitems() throws Exception {
		when(businessService.getall()).thenReturn(
				Arrays.asList()
				);
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/reports")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[]"))
				.andReturn();
		
	}


}
