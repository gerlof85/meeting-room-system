package com.github.gerlof85.dojo.mrrs.repository;

import static org.junit.Assert.*;
import java.io.StringReader;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.gerlof85.dojo.mrrs.domain.Facility;
import com.github.gerlof85.dojo.mrrs.domain.Room;

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
	public void createBuilder() throws Exception {
	    StringBuilder bldr = new StringBuilder();
	    //bldr.append("location; capacity; name; facilities\n");
	    bldr.append("1.14; 12; Amsterdam; Beamer, Computer\n");
	    //bldr.append("1.10; 10; Berlin; Phone\n");

//	    System.out.println(bldr.toString());
	    //assertEquals("01.12", bldr.g("01.12").getLocation());
	    
	    RoomRepository roomRepo = CsvRoomRepository.create(new StringReader(bldr.toString()));
	    //Room room = roomRepo.search("1.14");
	    assertEquals("Amsterdam", roomRepo.getByLocation("1.14").getName());
	    assertEquals("Coffeemaker", roomRepo.getByLocation("1.10").getFacility().getName());
	    assertEquals("Computer, Beamer", roomRepo.getByLocation("1.14").toStringFacilities());
	    
	    //assertEquals("1 Beamer", roomRepo.getByLocation("1.14").getFacilityAndNr());
	    //assertEquals("2 Computer", roomRepo.getByLocation("1.14").getFacilities());
	}
}