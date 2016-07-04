package com.github.gerlof85.dojo.mrrs.repository;

import com.github.gerlof85.dojo.mrrs.domain.Room;

public class RoomRepository {

	private Room room;
	private String locatieReturn;
	private int aantalKamers = 0;

	public void add(Room room) {
		this.room = room;
		aantalKamers ++;
		//System.out.println("Aantalkamers " + aantalKamers);
	}

	public String getByLocation(String locatie) {
		//Room locatie = room.getLocation();
		//this.location = room.getLocation();
		locatieReturn = "No room available with this location number";
		
		//System.out.println("room.getloc" + room.getLocation());
		
		for (int i = 0; i <= aantalKamers; i++) {
			if (room.getLocation().contains(locatie)) {
				locatieReturn = locatie;
			}
		}
		
		return locatieReturn;
	}

}
