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
}