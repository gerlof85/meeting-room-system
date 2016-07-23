package com.github.gerlof85.dojo.mrrs.it;

import com.github.gerlof85.dojo.mrrs.domain.Room;
import com.github.gerlof85.dojo.mrrs.domain.Facility;
import com.github.gerlof85.dojo.mrrs.repository.RoomRepository;
import static org.junit.Assert.*;

import java.util.LinkedHashSet;
import java.util.Set;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FindRoomByLocationSteps {
	private RoomRepository roomRepo = new RoomRepository();
	private Room currentRoom;
	
	@Given("^a room with name \"(.*?)\", location \"(.*?)\" and capacity (\\d+) and facility \"(.*?)\"$")
	public void a_room_with_name_location_and_capacity_and_facility(String name, String location, int capacity, String facs) throws Throwable {
		Set<Facility> facilities3 = new LinkedHashSet<>();
		facilities3.add(new Facility(facs));
		
		roomRepo.add(new Room(location, capacity, name, facilities3));
		currentRoom = roomRepo.getByLocation(location);
//	    throw new PendingException();
	}
	
//	
//	@Given("^which has facility \"(.*?)\"$")
//	public void which_has_facility(String locatie) throws Throwable {
//		Set<Facility> facilities = new LinkedHashSet<>();
//		
//		facilities.add(new Facility("Beamer"));
//		facilities.add(new Facility("Whiteboard"));
//		
//	    roomRepo.getByLocation(locatie).add(facilities);
//		System.out.println("implement");
////	    throw new PendingException();
//	}

	@When("^searching for room with location \"(.*?)\"$")
	public void searching_for_room_with_location(String location) throws Throwable {
	    assertEquals(currentRoom, roomRepo.getByLocation(location));
//	    throw new PendingException();
	}

	@Then("^the room with name \"(.*?)\" should be returned$")
	public void the_room_with_name_should_be_returned(String name) throws Throwable {
		assertEquals(name,currentRoom.getName());
//		System.out.println("sysout " + currentRoom.getLocation());
//	    throw new PendingException();
	}
	
	@Then("^the room should have facility \"(.*?)\"$")
	public void the_room_should_have_facility(String facility) throws Throwable {
		assertEquals(facility,currentRoom.toStringFacilities());
	    //throw new PendingException();
	}
	
}
