package com.github.gerlof85.dojo.mrrs.domain;

import org.apache.commons.lang3.StringUtils;

public class Facility {

	private String soortFacilityCln;
	private int facilityNummer;

	//constructor aanmaken
	public Facility(String soortFacility) {
		soortFacilityCln = StringUtils.trimToNull(soortFacility);
		if (soortFacilityCln == null) {
			throw new IllegalArgumentException("Name of facility should not be null.");
		}	
	}
	
	public Facility(String soortFacility, int facilityNummer) {
		facilityNummer = 0;
		
		soortFacilityCln = StringUtils.trimToNull(soortFacility);
		this.facilityNummer = facilityNummer;
		if (soortFacilityCln == null) {
			throw new IllegalArgumentException("Name of facility should not be null.");
		}	
		if (facilityNummer == 0) {
			throw new IllegalArgumentException("Number of facility should be provided.");
		}
	}

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
