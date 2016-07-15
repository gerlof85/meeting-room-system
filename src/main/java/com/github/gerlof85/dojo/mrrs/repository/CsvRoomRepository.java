package com.github.gerlof85.dojo.mrrs.repository;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;

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
				
				//line opsplitsen in array (per regel)      -     logger.info("  " + line);
				String[] regel = line.split("\\;", -1);
				//array regel: 0 = ruimtenr, 1 = capaciteit, 2 = naam, 3 = faciliteit(en) comma gescheiden
				
				String capacityCln = regel[1].trim();
				roomRepository.add(new Room(regel[0], Integer.parseInt(capacityCln), regel[2],new Facility(regel[3])));
				
				String faciliteiten = regel[3];
				
				//faciliteiten in arraylist stoppen en vervolgens objecten van aanmaken
				ArrayList aList= new ArrayList(Arrays.asList(faciliteiten.split(",")));
				
					for(int i=0;i<aList.size();i++)		
					{
					    roomRepository.getByLocation(regel[0]).add(new Facility((String) aList.get(i), i + 1));
					    //logger.info("  " + aList.get(i));
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
