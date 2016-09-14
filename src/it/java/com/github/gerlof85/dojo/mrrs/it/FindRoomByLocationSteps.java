package com.github.gerlof85.dojo.mrrs.it;

import com.github.gerlof85.dojo.mrrs.domain.Room;
import com.github.gerlof85.dojo.mrrs.domain.Facility;
import com.github.gerlof85.dojo.mrrs.repository.RoomRepository;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

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
	
	@Given("^a set with rooms has been imported$")
	public void a_set_with_rooms_has_been_imported() throws Throwable {
	    //start server here, csv2 with facilities will be imported
	}

	@When("^requesting room with location \"(.*?)\"$")
	public void requesting_room_with_location(String location) throws Throwable {
			roomServiceResponse(location);
	}
	
	@Then("^the room with name \"(.*?)\" should be returned by service$")
	public void the_room_with_name_should_be_returned_by_service(String arg1) throws Throwable {
		assertEquals(jsonString,output);
	}
	
	String output = null;
	String jsonString = "{\"name\":\"Rotterdam\",\"location\":\"1.08\",\"capacity\":12,\"facilities\":[{\"name\":\"Beamer\"},{\"name\":\"Computer\"},{\"name\":\"Table\"}]}";
	
	public void roomServiceResponse(String location) {
		try {

			Client client = Client.create();
			
			if (location.length() < 2){
				throw new IllegalArgumentException("Location may not be null.");
			}
			
			WebResource webResource = client.resource("http://localhost:8080/webapi/rooms/" + location);
			
			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
						
			if (response.getStatus() != 200){
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}
			
			output = response.getEntity(String.class);
//				System.out.println("Output from server...   \n");
//				System.out.println(output);
			
			//assertEquals(jsonString,output);
			
		  } catch (Exception e) {

			e.printStackTrace();

		  }
	}

}
