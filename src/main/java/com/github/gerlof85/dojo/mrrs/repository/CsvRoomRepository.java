package com.github.gerlof85.dojo.mrrs.repository;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.gerlof85.dojo.mrrs.domain.Facility;
import com.github.gerlof85.dojo.mrrs.domain.Room;

import org.csveed.api.CsvClient;
import org.csveed.api.CsvClientImpl;
import org.csveed.bean.BeanInstructionsImpl;
import org.csveed.bean.ColumnNameMapper;

public class CsvRoomRepository {
	private static Logger logger = LoggerFactory.getLogger(CsvRoomRepository.class);
	
	// create roomrepo with input comma separated string to an object containing rooms/facilities
	public static RoomRepository create(final Reader reader) {
		RoomRepository roomRepository = new RoomRepository();
		CsvClient<CsvRoom> csvReader = new CsvClientImpl<CsvRoom>(reader,
                new BeanInstructionsImpl(CsvRoom.class))
				.setMapper(ColumnNameMapper.class)
				.mapColumnNameToProperty("location", "location")
				.mapColumnNameToProperty("capacity", "capacity")
				.mapColumnNameToProperty("name", "name")
				.mapColumnNameToProperty("facilities", "facilities");
				
		final List<CsvRoom> rooms = csvReader.readBeans();
		for (CsvRoom csvRoom : rooms) {
			roomRepository.add(csvRoom.create());
		}
		
		return roomRepository;
	}
	
}
