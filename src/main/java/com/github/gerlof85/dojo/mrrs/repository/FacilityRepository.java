package com.github.gerlof85.dojo.mrrs.repository;

import com.github.gerlof85.dojo.mrrs.domain.Facility;
import com.github.gerlof85.dojo.mrrs.domain.Room;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

public class FacilityRepository {
	private Set<Facility> facilities = new LinkedHashSet<>();
	
	public void add(Facility facility) {	
		for (Facility fac : facilities) {
			if (fac.getName() == facility.getName()) {
				throw new IllegalArgumentException("Argument 'facility' with value '" + facility.getName() + "' has already been added.'");
			}
		}
		facilities.add(facility);
	}

	public Room search(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public int size() {
		return facilities.size();
	}

	public Set<Facility> getAll() {
		return facilities;
	}
	
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

}
