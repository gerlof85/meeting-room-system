package com.github.gerlof85.dojo.mrrs.domain;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class Facility {

	private String soortFacilityCln;
	private int facilityNummer;
	private Map<String, Facility> facilities = new LinkedHashMap<>();

	//constructor aanmaken
	public Facility(String soortFacility) {
		soortFacilityCln = StringUtils.trimToNull(soortFacility);
		if (soortFacilityCln == null) {
			throw new IllegalArgumentException("Name of facility should not be null.");
		}
	}
	
	public Facility(String soortFacility, int facilityNummer) {	
		soortFacilityCln = StringUtils.trimToNull(soortFacility);
		this.facilityNummer = facilityNummer;
		if (soortFacilityCln == null) {
			throw new IllegalArgumentException("Name of facility(with nr) should not be null.");
		}	
		//if (facilityNummer == 0) {
		//	throw new IllegalArgumentException("Number of facility should be provided.");
		//}
	}

/*	
	public void add(String locatie, Facility facility) {
		//if (facilities.containsKey(locatie)) {
		//	throw new IllegalArgumentException("Argument 'facility' with location '" + locatie + "' has already been added.'");
		//}
		
		facilities.put(locatie, facility);
	}
	
	public Facility getFacilitiesByLocation(String locatie) {
		if (! facilities.containsKey(locatie)) {
			throw new IllegalArgumentException("Argument 'locatie' with value '" + locatie + "' has no facilities.");
		}
		//TODO: return string or multiple objects
		return facilities.get(locatie);
	}
*/	

	//getter voor faci. naam
	public String getName() {
		return soortFacilityCln;
	}
	
	//getter voor faci. naam
	public String getNameNr() {
		String nummerName = Integer.toString(facilityNummer) + " " + soortFacilityCln;
		return nummerName;
	}

}
