package com.github.gerlof85.dojo.mrrs.repository;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
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
		Set<Facility> facilities = new HashSet<>();
		TreeSet<Facility> facTreeSet = new TreeSet<>();
		Set<Facility> facilities2 = new HashSet<>();
		
		try {
			String line = null;
			while ((line = lnr.readLine()) != null) {
				
				//line opsplitsen in array (per regel)      -     logger.info("  " + line);
				String[] regel = line.split("\\;", -1);
				//array regel: 0 = ruimtenr, 1 = capaciteit, 2 = naam, 3 = faciliteit(en) comma gescheiden
				
				String faciliteiten = regel[3];
				String capacityCln = regel[1].trim();
				//roomRepository.add(new Room(regel[0], Integer.parseInt(capacityCln), regel[2],new Facility(regel[3])));
				
				ArrayList<String> aList= new ArrayList<String>(Arrays.asList(faciliteiten.split(",")));
				
				for(int i=0;i<aList.size();i++)	 //na splitten faciliteiten aan HashSet toevoegen	
				{
					facilities.add(new Facility(aList.get(i)));
				}
				// nieuwe kamer incl. faciliteiten aanmaken
				roomRepository.add(new Room(regel[0], Integer.parseInt(capacityCln), regel[2], facilities));
				
			}	
			facilities2.add(new Facility("Coffeemaker"));  //tijdelijke oplossing, nog dynamisch maken
			roomRepository.add(new Room("1.10", 10, "Stockholm", facilities2));
			
			//logger.info("  " + facilities2.size());
			//logger.info("  " + roomRepository.getByLocation("1.10").hasFacility("Coffeemaker"));
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return roomRepository;
	}
	
}
