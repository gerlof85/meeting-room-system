package com.github.gerlof85.dojo.mrrs.repository;

import com.github.gerlof85.dojo.mrrs.domain.Facility;
import com.github.gerlof85.dojo.mrrs.domain.Room;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class RoomRepository {
//	private ArrayList<Room> rooms = new ArrayList<Room>();
	private Map<String, Room> rooms = new LinkedHashMap<>();
	private Set<Room> roomSet = new LinkedHashSet<>();
	
	public void add(Room room) {
		if (rooms.containsKey(room.getLocation())) {
			throw new IllegalArgumentException("Argument 'room' with location '" + room.getLocation() + "' has already been added.'");
		}
		
		rooms.put(room.getLocation(), room);
//		System.out.println(room.getLocation() + " " + room.getLocation() + " " + room.getCapacity() + " " + room.getFacilities());
//		rooms.add( room );
	}

	public Room getByLocation(String locatie) {
		if (! rooms.containsKey(locatie)) {
			throw new IllegalArgumentException("Argument 'locatie' with value '" + locatie + "' is not a known room.");
		}
		//rooms.get(locatie).getLocation()
		return rooms.get(locatie);
	}	
	
	
	public Set<Facility> getFacilitiesPerRoom(String locatie){
		if (! rooms.containsKey(locatie)) {
			throw new IllegalArgumentException("Argument 'locatie' with value '" + locatie + "' is not a known room.");
		}
		return rooms.get(locatie).getFacilities();
	}
	
		
//		for (Room room : rooms) {
//			if (room.getLocation().equalsIgnoreCase(locatie)) {
//				return room;
//			} 
//		}
		

	public Room search(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public int size() {
		return rooms.size();
	}

	public Map<String, Room> getAll() {
		//roomSet.add(rooms.get("1.08"));
		return rooms;
	}

//	public Set<Room> getAll() {
//		roomSet.add(rooms.get("1.08"));
//		return roomSet;
//	}

}
