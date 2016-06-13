package com.github.gerlof85.dojo.mrrs;

import org.apache.commons.lang3.StringUtils;

public class Facility {

	private String soortFacilityCln;

	//constructor aanmaken
	public Facility(String soortFacility) {
		soortFacilityCln = StringUtils.trimToNull(soortFacility);
		if (soortFacilityCln == null) {
			throw new IllegalArgumentException("Name of facility should not be null.");
		}
		
	}

	//getter voor faci. naam
	public String getName() {
		return soortFacilityCln;
	}

}
