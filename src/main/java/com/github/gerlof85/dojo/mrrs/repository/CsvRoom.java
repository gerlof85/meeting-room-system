package com.github.gerlof85.dojo.mrrs.repository;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.github.gerlof85.dojo.mrrs.domain.Facility;
import com.github.gerlof85.dojo.mrrs.domain.Room;

public class CsvRoom {
	private String name;
	private String location;
	private int capacity;
	private String facilities;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getFacilities() {
		return facilities;
	}
	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}
	public Room create() {
		return new Room(location, capacity, name, createFacilities(getFacilities()));
	}
	private Set<Facility> createFacilities(final String facilitiesStr) {
		final String facilitiesCln = StringUtils.trimToNull(facilitiesStr);
		if (facilitiesCln == null) {
			return Collections.emptySet();
		}
		
		String[] facilityArr = facilitiesCln.split(",");
		Set<Facility> facilities = new LinkedHashSet<>();
		for (String facility : facilityArr) {
			facilities.add(new Facility(facility));
		}
		return facilities;
	}
	
}
