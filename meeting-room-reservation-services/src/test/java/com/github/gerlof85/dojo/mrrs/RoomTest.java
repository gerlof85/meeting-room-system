package com.github.gerlof85.dojo.mrrs;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoomTest {
	@Test
	public void createBasicRoom() throws Exception {
		String name = "Sieben";
		String location = "01.12";
		int capacity = 10;
		
		Room room = new Room(name, location, capacity);
		
		assertEquals("Sieben", room.getName());
		assertEquals("01.12", room.getLocation());
		assertEquals(10, room.getCapacity());
	}

	@Test
	public void createBasicRoom2() throws Exception {
		String name = "  Funf  ";
		String location = "  01.10  ";
		int capacity = 2;
		
		Room room = new Room(name, location, capacity);
		
		assertEquals("Funf", room.getName());
		assertEquals("01.10", room.getLocation());
		assertEquals(2, room.getCapacity());
	}
	@Test
	public void createBasicRoom3() throws Exception {
		String name = null;
		String location = " 01.14\t ";
		int capacity = 2;
		
		Room room = new Room(name, location, capacity);
		
		assertNull(room.getName());
		assertEquals("01.14", room.getLocation());
		assertEquals(2, room.getCapacity());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void createRoomLocationNull() throws Exception {
		String name = "Sechs";
		String location = null;
		int capacity = 10;
		
		new Room(name, location, capacity);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void createRoomLocationEmpty() throws Exception {
		String name = "Sieben";
		String location = "  \t";
		int capacity = 10;
		
		new Room(name, location, capacity);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void createRoomCapacityIncorrect() throws Exception {
		String name = "Sieben";
		String location = "  \t";
		int capacity = -10;
		
		new Room(name, location, capacity);
	}
	
	// voegt een facility(beamer) toe aan een room
	@Test
	public void addFacility() throws Exception {
		String name = "";
		String location = "01.13";
		int capacity = 8;
		
		//nieuwe kamer aanmaker
		Room room = new Room(name, location, capacity);
		
		Facility facility = new Facility("Beamer");
		
		room.add(facility);
		
		assertEquals("Beamer", room.getFacility());
	}
}