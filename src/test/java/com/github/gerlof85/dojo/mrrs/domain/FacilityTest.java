package com.github.gerlof85.dojo.mrrs.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class FacilityTest {
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
}
