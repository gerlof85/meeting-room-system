package com.github.gerlof85.dojo.mrrs.repository;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.gerlof85.dojo.mrrs.domain.Facility;

public class FacilityRepositoryTest {
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void create() throws Exception {
		FacilityRepository facRepo = new FacilityRepository();
		
		facRepo.add(new Facility("Commodore64"));
		facRepo.add(new Facility("Laptop"));
		
		assertEquals("Commodore64, Laptop", facRepo.toStringFacilities());
		assertNotNull(facRepo.getAll());
		assertEquals(2, facRepo.size());
	}
	
	@Test
	public void createDuplicate() throws Exception {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Argument 'facility' with value 'Phone' has already been added.");
		
		
		FacilityRepository facRepo = new FacilityRepository();
		
		facRepo.add(new Facility("Phone"));
		facRepo.add(new Facility("Phone"));
	}

	@Test
	public void createSameName() throws Exception {
		String eersteFac = "Phone";
		String tweedeFac = "PhonE";
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Argument 'facility' with value '" + tweedeFac +"' has already been added.");
		
		FacilityRepository facRepo = new FacilityRepository();
		
		facRepo.add(new Facility(eersteFac));
		facRepo.add(new Facility(tweedeFac));
	}
	
}
