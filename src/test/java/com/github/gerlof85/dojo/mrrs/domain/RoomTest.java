package com.github.gerlof85.dojo.mrrs.domain;

import static org.junit.Assert.*;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.gerlof85.dojo.mrrs.repository.RoomRepository;

public class RoomTest {
	@Rule
	public ExpectedException exception = ExpectedException.none();


	@Test
	public void createBasicRoom() throws Exception {
		String name = "Sieben";
		String location = "01.12";
		int capacity = 10;
		
		Room room = new Room(location, capacity, name);
		
		assertEquals("Sieben", room.getName());
		assertEquals("01.12", room.getLocation());
		assertEquals(10, room.getCapacity());
	}

	@Test
	public void createBasicRoom2() throws Exception {
		String name = "  Funf  ";
		String location = "  01.10  ";
		int capacity = 2;
		
		Room room = new Room(location, capacity, name);
		
		assertEquals("Funf", room.getName());
		assertEquals("01.10", room.getLocation());
		assertEquals(2, room.getCapacity());
	}

	@Test
	public void createBasicRoom3() throws Exception {
		String name = null;
		String location = " 01.14\t ";
		int capacity = 2;
		
		Room room = new Room(location, capacity, name);
		
		assertNull(room.getName());
		assertEquals("01.14", room.getLocation());
		assertEquals(2, room.getCapacity());
	}
	
	@Test
	public void createRoomSeperateFacility() throws Exception {
		String name = null;
		String location = " 01.14\t ";
		int capacity = 2;
		
//		RoomRepository roomRepo = new RoomRepository();
//		Set<Facility> facilities3 = new LinkedHashSet<>();
//		facilities3.add(new Facility("Table, Plant"));
//		
//		roomRepo.add(new Room("1.16", 17, "Stockholm", facilities3));
		
		
		Set<Facility> facilities = new LinkedHashSet<>();
		facilities.add(new Facility("Full HD Beamer"));
		
		Room room = new Room(location, capacity, name);
		room.replaceFacilities(facilities);
		
		assertNull(room.getName());
		assertEquals("01.14", room.getLocation());
		assertEquals(2, room.getCapacity());
		assertEquals("Full HD Beamer", room.toStringFacilities());
	}
	
	@Test
	public void createRoomLocationNull() throws Exception {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Argument 'location' should not be null.");

		String name = "Sechs";
		String location = null;
		int capacity = 10;
		
		new Room(location, capacity, name);
	}
	
	@Test
	public void createRoomLocationEmpty() throws Exception {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Argument 'location' should not be null.");

		String name = "Sieben";
		String location = "  \t";
		int capacity = 10;
		
		new Room(location, capacity, name);
	}
	
	@Test
	public void createRoomCapacityIncorrect() throws Exception {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Argument 'capacity' with value '-10' should be larger then 0.");
		String name = "Sieben";
		String location = " 08.01 ";
		int capacity = -10;
		
		new Room(location, capacity, name);
	}
	
	// voegt een facility(beamer) toe aan een room
	@Test
	public void addFacility() throws Exception {
		String name = "";
		String location = "01.13";
		int capacity = 8;
	
		
		//Facility facility = new Facility("Beamer");
		
		Set<Facility> facilities = new LinkedHashSet<>();
		facilities.add(new Facility("Beamer"));
	
		//nieuwe kamer aanmaker
		Room room = new Room(location, capacity, name, facilities);
		
		//room.add(facilities);
		
		assertEquals("Beamer", room.toStringFacilities());
		assertEquals(facilities, room.getFacilities());
		assertEquals(8, room.getCapacity());
		assertEquals("01.13", room.getLocation());
		assertEquals(null, room.getName());
	}
	
	@Test
	public void addFacilityLocationNull() throws Exception {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Argument 'location' should not be null.");
		
		String name = "";
		String location = null;
		int capacity = 8;
		
		Set<Facility> facilities = new LinkedHashSet<>();
		facilities.add(new Facility("Beamer"));
	
		//nieuwe kamer aanmaker
		Room room = new Room(location, capacity, name, facilities);
	}
	
	@Test
	public void addFacilityCapacityNegative() throws Exception {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Argument 'capacity' with value '-8' should be larger then 0");
		
		String name = "";
		String location = "1.81";
		int capacity = -8;
		
		Set<Facility> facilities = new LinkedHashSet<>();
		facilities.add(new Facility("Beamer"));
	
		//nieuwe kamer aanmaker
		Room room = new Room(location, capacity, name, facilities);
	}
	
	// voegt een facility(beamer) toe aan een room
	@Test
	public void addMultipleFacilities() throws Exception {
		String name = "";
		String location = "01.13";
		int capacity = 8;
		
		Set<Facility> facilities = new LinkedHashSet<>();
		
		facilities.add(new Facility("Beamer"));
		facilities.add(new Facility("Whiteboard"));
		
		//nieuwe room aanmaker
		Room room = new Room(location, capacity, name, facilities);

		assertEquals("Beamer, Whiteboard", room.toStringFacilities());
		assertEquals(facilities, room.getFacilities());
		assertEquals(8, room.getCapacity());
		assertEquals("01.13", room.getLocation());
		assertEquals(null, room.getName());
		
		assertEquals(true, room.hasFacility("Whiteboard")); //hasFacility checks
		assertNotEquals(true, room.hasFacility("Coffeemaker"));
		
	}
}