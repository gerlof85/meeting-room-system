package com.github.gerlof85.dojo.mrrs.repository;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.gerlof85.dojo.mrrs.domain.Facility;
import com.github.gerlof85.dojo.mrrs.domain.Room;

public class CsvRoomRepository {
	private static Logger logger = LoggerFactory.getLogger(CsvRoomRepository.class);
	
	// create roomrepo with input comma separated string to an object containing rooms/facilities
	public static RoomRepository create(final Reader reader) {
		RoomRepository roomRepository = new RoomRepository();
		LineNumberReader lnr = new LineNumberReader(reader);
		
		try {
			String line = null;
			while ((line = lnr.readLine()) != null) {
				
				Set<Facility> facilities = new LinkedHashSet<>(); //for each rule: make new facilities object
				
				String[] regel = line.split("\\;", -1);  //line opsplitsen in array (per regel)  -  logger.info("  " + line);
				//array regel: 0 = ruimtenr, 1 = capaciteit, 2 = naam, 3 = faciliteit(en) comma gescheiden
				
				String faciliteiten = regel[3];  //get facilities (in short facs)
				String capacityCln = regel[1].trim();  //get capacity
				
				if (!capacityCln.contains("capacity")) {   //continue only if rule is not the header rule)
					ArrayList<String> aList= new ArrayList<String>(Arrays.asList(faciliteiten.split(",")));  //split facs
					
					for(int i=0;i<aList.size();i++)	  //after splitten facs, add to new linkedHashSet 1 by 1
					{
						facilities.add(new Facility(aList.get(i)));
					}
					// add new room incl. facs
					roomRepository.add(new Room(regel[0].trim(), Integer.parseInt(capacityCln), regel[2].trim(), facilities));
				}
			}	
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return roomRepository;
	}
	
}
