package com.github.gerlof85.dojo.mrrs.repository;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
				//logger.info("  " + line);
				String[] array = line.split("\\;", -1);
				//logger.info(" split " + array[0]);
				//Todo: line opknippen a/h/v/ mapColumnNameToProperty (CSVeed)
				//Room room = new Room(array[0], Integer.parseInt(array[1]), array[2]);
				
				roomRepository.add(new Room(array[0], 12, "Zehn"));
				logger.info(roomRepository.getByLocation(array[0]).getLocation());				
				}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}
