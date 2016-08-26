package com.github.gerlof85.dojo.mrrs.repository;

import com.github.gerlof85.dojo.mrrs.ReadFile;
import com.github.gerlof85.dojo.mrrs.domain.Facility;
import com.github.gerlof85.dojo.mrrs.domain.Room;

import java.io.FileNotFoundException;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

public class FacilityRepository {
	private Set<Facility> facilities = new LinkedHashSet<>();
	
	public void add(Facility facility) {	
		for (Facility fac : facilities) {
			if (fac.getName().equalsIgnoreCase(facility.getName())) {
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

	public Facility getFacility(int i) {
		return (Facility) facilities.toArray()[i];
	}

	public static FacilityRepository createFromCSV(String fileLoc) throws FileNotFoundException {
		StringBuilder bldr = new ReadFile().ReadCSVFile(fileLoc);
	    //FacilityRepository facRepo = CsvFacilityRepository.create(new StringReader(bldr.toString()));
	    
		//string fileLoc input, facRepo als output
		String facilitiesCln = bldr.toString();
		String[] facilityArr = facilitiesCln.split(",");
		FacilityRepository facRepo = new FacilityRepository();
		
		for (String facility : facilityArr) {
			//if (facility == facilityArr[0]) continue;
			facRepo.add(new Facility(facility));
		}
		return facRepo;
	}

}
