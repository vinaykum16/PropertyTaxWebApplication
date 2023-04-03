package com.example.property_tax.service;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Locale;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.property_tax.services.impl.TaxFormServiceImpl;

public class TaxFormServiceImplTest {
	
	 private static final Locale FRANCE = Locale.FRANCE;

	  @InjectMocks
	  private TaxFormServiceImpl serviceImpl;
	  
	  @Autowired
	private MockMvc mockMvc;

	  
	  @org.junit.jupiter.api.Test
		public void retrieveAllItems_noitems() throws Exception {
			when(serviceImpl.getall()).thenReturn(
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
