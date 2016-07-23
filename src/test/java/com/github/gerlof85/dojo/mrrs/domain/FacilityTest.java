package com.github.gerlof85.dojo.mrrs.domain;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.Test;

public class FacilityTest {
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void createBeamer() throws Exception {
		Facility facility = new Facility("Beamer");
		
		assertEquals("Beamer", facility.getName());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void emptyFacility() throws Exception {
		Facility facility = new Facility("");
		
		assertEquals("", facility.getName());
	}
	
	@Test
	public void facilityWithNumber() throws Exception {
		Facility facility = new Facility("PC", 0);
		
		assertEquals("PC", facility.getName());
		assertEquals("0 PC", facility.getNameNr());
	}
	
	@Test
	public void facilityWithNumberAndNameEmpty() throws Exception {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Name of facility(with nr) should not be null.");
		
		Facility facility = new Facility(null, 0);
	}
}
