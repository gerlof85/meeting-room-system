package com.github.gerlof85.dojo.mrrs.repository;

import com.github.gerlof85.dojo.mrrs.domain.Room;
import java.util.ArrayList;

public class RoomRepository {

	private Room room;
	private String locatieReturn;
	private int aantalKamers = 0;

	ArrayList<Room> rooms = new ArrayList<Room>();
	
	public void add(Room room) {
		rooms.add( room );
	}

	public String getByLocation(String locatie) {
		//this.location = room.getLocation();
		
		locatieReturn = "No rooms available with this location number";
				
		//searchRoom(locatie);
		for (Room r : rooms){
			if(r.getLocation().contains(locatie)){
				locatieReturn = locatie;
			} 
		}
		
		return locatieReturn;
	}

	public int getCapacity(String locatie) {
		int capaciteit = 0;
		
		for (Room r : rooms){
			if(r.getLocation().contains(locatie)){
				capaciteit = r.getCapacity();
			}
		}
		return capaciteit;
	}

	/*  old inefficient code
		//this.room = room;
		//aantalKamers ++; 
	  
	for (int i = 0; i <= aantalKamers; i++) {
		if (room.getLocation().contains(locatie)) {
			//zelfde vragen als bij getCapacity
			locatieReturn = locatie;
		}
	}
	return locatieReturn;		*/
	
}
