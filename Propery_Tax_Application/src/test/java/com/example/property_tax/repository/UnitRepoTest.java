package com.example.property_tax.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.property_tax.entity.UnitAreaValue;

@DataJpaTest
public class UnitRepoTest {
	
	@Autowired
	private UnitAreaValueRepo repository;
	
	@Test
	public void testFindAll() {
		List<UnitAreaValue> items = repository.findAll();
		assertEquals(18,items.size());
	}

	@Test
	public void testFindOne() {
		UnitAreaValue item = repository.findById(1).get();
		
		assertEquals(2.50,item.getUaValue());
	}

}
