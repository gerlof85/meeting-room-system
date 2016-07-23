package com.github.gerlof85.dojo.mrrs.domain;

import java.util.Set;
import org.apache.commons.lang3.StringUtils;

public class Room {

	private final String name;
	private final String location;
	private final int capacity;
	private Set<Facility> facilities;

	public Room(String location, int capacity, String name) {
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

	//versie incl facility
	public Room(String location, int capacity, String name, Set<Facility> facilities) {
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
		this.facilities = facilities;
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

	public void replaceFacilities(Set<Facility> facilities2) {
		this.facilities = facilities2;
	}

	public Set<Facility> getFacilities(){
		return facilities;
	}
	
//	public Set<Facility> getFacility(){
//		Set<Facility> selectedFacilities = null;
//		//Facility fac = new Facility("Coffeemaker");
//		
//		for (Facility facility : facilities ) {
//			if(facility.equals(facilities)) {
//				selectedFacilities.add(facility);
//				//System.out.println("fac gevonden");
//				//return facility;
//			}
//		}
//		return selectedFacilities;
//	}
	
	public String toStringFacilities() {
		StringBuilder bldr = new StringBuilder();
		for (Facility facility : facilities) {
			if (bldr.length() > 0) {
				bldr.append(", ");
			}
			bldr.append(facility.getName());
		}
		return bldr.toString();
	}

	public boolean hasFacility(String facilityName) {
		Facility fac = new Facility(facilityName);
		boolean facExists = false;
		
		for (Facility facility : facilities ) {
			if(facility.getName().equals(fac.getName())) {
				//System.out.println("fac gevonden");
				facExists = true;
			}
		}
		return facExists;
	}

}
