package com.example.property_tax.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.property_tax.entity.AllZones;

@DataJpaTest
public class AllZonesTest {
	
	@Autowired
	private AllZonesRepo repository;
	
	@Test
	public void testFindAll() {
		List<AllZones> items = repository.findAll();
		assertEquals(3,items.size());
	}

	@Test
	public void testFindOne() {
		AllZones item = repository.findById(1).get();
		
		assertEquals("Zone A",item.getZones());
	}

}
