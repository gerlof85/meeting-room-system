package com.github.gerlof85.dojo.mrrs.repository;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.gerlof85.dojo.mrrs.domain.Facility;
import com.github.gerlof85.dojo.mrrs.domain.Room;

public class CsvRoomRepository {
	private static Logger logger = LoggerFactory.getLogger(CsvRoomRepository.class);
	
	// static of niet
	public static RoomRepository create(final Reader reader) {
		RoomRepository roomRepository = new RoomRepository();
		LineNumberReader lnr = new LineNumberReader(reader);
		
		try {
			String line = null;
			while ((line = lnr.readLine()) != null) {
				
				//line opsplitsen in array (per regel)      -     logger.info("  " + line);
				String[] array = line.split("\\;", -1);
				
				String capacityCln = array[1].trim();
				roomRepository.add(new Room(array[0], Integer.parseInt(capacityCln), array[2],new Facility(array[3])));
					
				}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return roomRepository;
	}
	
}
