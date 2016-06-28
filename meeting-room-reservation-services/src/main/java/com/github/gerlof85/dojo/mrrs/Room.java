package com.github.gerlof85.dojo.mrrs;

public class Room {

	private final String name;
	private final String location;
	private final int capacity;
	private Facility facility;

	public Room(String name, String location, int capacity) {
		this.name = name;
		this.location = location;
		this.capacity = capacity;
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public int getCapacity() {
		return capacity;
	}

	public void add(Facility facility) {
		this.facility = facility;
	}

	public String getFacility() {
		return facility.getName();
	}

}
