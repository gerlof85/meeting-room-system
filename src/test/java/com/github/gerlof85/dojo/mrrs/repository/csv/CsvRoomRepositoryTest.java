package com.github.gerlof85.dojo.mrrs.repository.csv;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.StringReader;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.gerlof85.dojo.mrrs.ReadFile;
import com.github.gerlof85.dojo.mrrs.repository.RoomRepository;

public class CsvRoomRepositoryTest {
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void readFromCSV() throws Exception {
	    StringBuilder bldr = new ReadFile().ReadCSVFile("");
		
	    //assertEquals("01.12", bldr.g("01.12").getLocation());
	    
	    RoomRepository roomRepo = CsvRoomRepository.create(new StringReader(bldr.toString()));
	    //Room room = roomRepo.search("1.14");
	    assertEquals("Amsterdam", roomRepo.getByLocation("1.11").getName());
	    assertEquals("Beamer, Computer", roomRepo.getByLocation("1.11").toStringFacilities());
	    assertEquals("Phone", roomRepo.getByLocation("1.09").toStringFacilities());   
	}
	
	@Test
	public void readFromAlternativeCSV() throws Exception {
		StringBuilder bldr = new ReadFile().ReadCSVFile("src/test/resources/facilities2.csv");
		
	    //assertEquals("01.12", bldr.g("01.12").getLocation());
	    
	    RoomRepository roomRepo = CsvRoomRepository.create(new StringReader(bldr.toString()));
	    assertNotNull(roomRepo);
	    assertTrue(roomRepo.size() > 0);
	    //Room room = roomRepo.search("1.14");
	    assertEquals("Rotterdam", roomRepo.getByLocation("1.08").getName());
	    assertEquals("Beamer, Computer", roomRepo.getByLocation("1.08").toStringFacilities());
	    assertEquals("Phone", roomRepo.getByLocation("1.07").toStringFacilities()); 
		
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
