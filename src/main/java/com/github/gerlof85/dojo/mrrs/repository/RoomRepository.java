package com.github.gerlof85.dojo.mrrs.repository;

import com.github.gerlof85.dojo.mrrs.domain.Room;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RoomRepository {
//	private ArrayList<Room> rooms = new ArrayList<Room>();
	private Map<String, Room> rooms = new HashMap<>();
	

	public void add(Room room) {
		if (rooms.containsKey(room.getLocation())) {
			throw new IllegalArgumentException("Argument 'room' with location '" + room.getLocation() + "' has already been added.'");
		}
		
		rooms.put(room.getLocation(), room);
//		rooms.add( room );
	}

	public Room getByLocation(String locatie) {
		if (! rooms.containsKey(locatie)) {
			throw new IllegalArgumentException("Argument 'locatie' with value '" + locatie + "' is not a known room.");
		}

		return rooms.get(locatie);
		
//		for (Room room : rooms) {
//			if (room.getLocation().equalsIgnoreCase(locatie)) {
//				return room;
//			} 
//		}
		
	}

	public Room search(String string) {
		// TODO Auto-generated method stub
		return null;
	}

//	public int getCapacity(String locatie) {
//		int capaciteit = 0;
//		
//		for (Room r : rooms){
//			if(r.getLocation().contains(locatie)){
//				capaciteit = r.getCapacity();
//			}
//		}
//		return capaciteit;
//	}

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
