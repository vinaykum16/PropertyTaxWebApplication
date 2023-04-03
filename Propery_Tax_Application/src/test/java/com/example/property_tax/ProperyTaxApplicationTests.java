package com.example.property_tax;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.BindingResult;

import com.example.property_tax.controller.TaxFormControlller;
import com.example.property_tax.entity.AllZones;
import com.example.property_tax.entity.Description;
import com.example.property_tax.entity.Status;
import com.example.property_tax.entity.TaxForm;
import com.example.property_tax.services.TaxFormService;

@SpringBootTest
class ProperyTaxApplicationTests {

	@Autowired
	private TaxFormService service;
	
	
	@Autowired
	private TaxFormControlller controller;

	
	private BindingResult br;
	
	private TaxForm testingForm;
	private Status status;
	private Description desc;
	private AllZones zone;
	
	
	@BeforeEach
	void setup()
	{
		testingForm=new TaxForm();
		testingForm.setId(1);
		testingForm.setName("saii");
		testingForm.setAddress("hyderabad");
		testingForm.setArea(1200);
		testingForm.setStatus("1");
		testingForm.setZone("1");
		testingForm.setDescription("1");
		 status=service.getStatusByID(1);
		 desc=service.getdescByID(1);
		 zone=service.gezoneByID(1);
		
	}
	
	
	@Test
	void uavCalculation()
	{
		double d=service.getUav(status,desc,zone);
		assertEquals(2.50,d);
	}
	
	
	@Test
	void errorform()
	{
		String s=controller.taxed(testingForm, br);
		assertEquals("taxform",s);
	}

}
