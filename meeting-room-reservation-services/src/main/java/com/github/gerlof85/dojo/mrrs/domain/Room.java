package com.github.gerlof85.dojo.mrrs.domain;

import org.apache.commons.lang3.StringUtils;

public class Room {

	private final String name;
	private final String location;
	private final int capacity;
	private Facility facility;

	public Room(String name, String location, int capacity) {
		String nameCln = StringUtils.trimToNull(name);
		String locationCln = StringUtils.trimToNull(location);
		if (locationCln == null) {
			throw new IllegalArgumentException("Argument 'location' should not be null.");
		}
		if (capacity <= 0) {
			throw new IllegalArgumentException("Argument 'capacity' with value '" + capacity + "' should be larger then 0.");
		}
				
		this.name = nameCln;
		this.location = locationCln;
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
