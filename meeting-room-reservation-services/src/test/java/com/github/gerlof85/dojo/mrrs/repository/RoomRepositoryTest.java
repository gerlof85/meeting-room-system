package com.github.gerlof85.dojo.mrrs.repository;

import static org.junit.Assert.*;

import org.junit.Test;

import com.github.gerlof85.dojo.mrrs.domain.Room;

public class RoomRepositoryTest {

	@Test

	public void create() throws Exception {

		RoomRepository repo = new RoomRepository();
		repo.add(new Room("01.10", 12, "Zwölf"));
		repo.add(new Room("01.12", 16, null));
		//repo.add(new Room("01.14", 20, "  Dreizehn  "));
		
		
		//Room room = repo.getByLocation("01.10");

		assertEquals("01.12", repo.getByLocation("01.12"));
		//assertEquals(11, repo.getCapacity("01.12"));

	}

}