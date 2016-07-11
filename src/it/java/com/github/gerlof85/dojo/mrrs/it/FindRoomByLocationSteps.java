package com.github.gerlof85.dojo.mrrs.it;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FindRoomByLocationSteps {

	@Given("^a room with name \"(.*?)\", location \"(.*?)\" and capacity (\\d+)$")
	public void a_room_with_name_location_and_capacity(String arg1, String arg2, int arg3) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("cucumber given");
	    throw new PendingException();
	}
	
	@Given("^which has facility \"(.*?)\"$")
	public void which_has_facility(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^searching for room with location \"(.*?)\"$")
	public void searching_for_room_with_location(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the room with name \"(.*?)\" should be returned$")
	public void the_room_with_name_should_be_returned(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
}
