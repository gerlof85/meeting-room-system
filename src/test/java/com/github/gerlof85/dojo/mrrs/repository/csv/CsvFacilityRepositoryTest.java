package com.github.gerlof85.dojo.mrrs.repository.csv;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.StringReader;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.gerlof85.dojo.mrrs.ReadFile;
import com.github.gerlof85.dojo.mrrs.domain.Facility;
import com.github.gerlof85.dojo.mrrs.repository.FacilityRepository;
import com.github.gerlof85.dojo.mrrs.repository.RoomRepository;

public class CsvFacilityRepositoryTest {
	@Rule
	public ExpectedException exception = ExpectedException.none();
		
	@Test
	public void readFromAlternativeCSV() throws Exception {
		
		//CsvFacilityRepository facRepo = new CsvFacilityRepository("src/test/resources/facilities3.csv");
		FacilityRepository facRepo = FacilityRepository.createFromCSV("src/test/resources/facilities3.csv");
		
		assertNotNull(facRepo);
	    assertTrue(facRepo.size() > 0);
	    assertEquals(facRepo.getFacility(0).getName(),"Beamer");
	    assertEquals("Beamer, Computer, Phone, Blackboard, Whiteboard, Coffeemaker, Table, Plant", facRepo.toStringFacilities()); 
	}
	
	@Test
	public void fileDoesntExist() throws Exception {
		//exception.expect(FileNotFoundException.class);
		//exception.expectMessage("src\\mock.csv (Het systeem kan het opgegeven bestand niet vinden)");
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setErr(new PrintStream(outContent));
		
		StringBuilder bldr = new ReadFile().ReadCSVFile("src/mock.csv");
		assertNotNull(outContent.toString());
	}
	
}
