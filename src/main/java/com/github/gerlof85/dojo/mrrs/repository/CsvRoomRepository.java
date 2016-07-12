package com.github.gerlof85.dojo.mrrs.repository;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
				//Todo: line opknippen a/h/v/ mapColumnNameToProperty (CSVeed)
				
				//roomRepository.add(line);
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}
