package com.github.gerlof85.dojo.mrrs.repository;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.gerlof85.dojo.mrrs.ReadFile;
import com.github.gerlof85.dojo.mrrs.domain.Facility;
import com.github.gerlof85.dojo.mrrs.domain.Room;
import com.github.gerlof85.dojo.mrrs.repository.csv.CsvRoomRepository;

public class RoomRepositoryTest {
	@Rule
	public ExpectedException exception = ExpectedException.none();
	

	@Test
	public void create() throws Exception {
		RoomRepository repo = new RoomRepository();
		
		repo.add(new Room("01.10", 12, "Zwölf"));
		repo.add(new Room("01.12", 16, null));
		repo.add(new Room("01.14", 20, "  Dreizehn  "));
		
		assertEquals("01.12", repo.getByLocation("01.12").getLocation());
		assertNull(repo.getByLocation("01.12").getName());

		assertEquals(20, repo.getByLocation("01.14").getCapacity());
		
		assertEquals("Zwölf", repo.getByLocation("01.10").getName());
	}

	@Test
	public void createDoubleLocation() throws Exception {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Argument 'room' with location '01.10' has already been added.");
		
		RoomRepository repo = new RoomRepository();
		
		repo.add(new Room("01.10", 12, "Zwölf"));
		repo.add(new Room("01.10", 16, null));
	}
	
	@Test
	public void nonExistingRoom() throws Exception {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Argument 'locatie' with value '1.11' is not a known room.");
		
		RoomRepository repo = new RoomRepository();
		
		repo.add(new Room("01.10", 12, "Zwölf"));
		repo.getByLocation("1.11");
	}
	
	@Test
	public void getFacilitiesPerRoom() throws Exception {
		RoomRepository roomRepo = new RoomRepository();
		Set<Facility> facilities3 = new LinkedHashSet<>();
		facilities3.add(new Facility("Table, Plant"));
		
		roomRepo.add(new Room("1.16", 17, "Stockholm", facilities3));
		
		assertEquals(facilities3,roomRepo.getFacilitiesPerRoom("1.16"));
	}
	
	@Test
	public void getFacilitiesPerRoomDoesntExist() throws Exception {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Argument 'locatie' with value '1.17' is not a known room.");
		
		RoomRepository repo = new RoomRepository();
		
		repo.add(new Room("01.10", 12, "Zwölf"));
		repo.getFacilitiesPerRoom("1.17");
	}
	
	@Test
	public void createBuilder() throws Exception {
	    StringBuilder bldr = new StringBuilder();
	    
	    bldr.append("location; capacity; name; facilities\n");
	    bldr.append("  1.14   ; 12; Amsterdam   ; Beamer, Computer\n");
	    bldr.append("1.10; 10; Berlin; Phone\n");

	    RoomRepository roomRepo = CsvRoomRepository.create(new StringReader(bldr.toString()));
	    //Room room = roomRepo.search("1.14");
	    assertEquals("Amsterdam", roomRepo.getByLocation("1.14").getName());
	    assertEquals("Beamer, Computer", roomRepo.getByLocation("1.14").toStringFacilities());
	    assertEquals("Phone", roomRepo.getByLocation("1.10").toStringFacilities());   
	}

}