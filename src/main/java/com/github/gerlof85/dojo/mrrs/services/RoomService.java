package com.github.gerlof85.dojo.mrrs.services;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.gerlof85.dojo.mrrs.domain.Room;
import com.github.gerlof85.dojo.mrrs.repository.RoomRepository;
import com.github.gerlof85.dojo.mrrs.repository.csv.CsvRoomRepository;

/**
 * Root resource (exposed at "myresource" path)
 * @param <JSon>
 */
@Path("rooms")
public class RoomService<JSon> {
    private RoomRepository roomRepo;
    
	public RoomService() {
		try {
			roomRepo = CsvRoomRepository.create(new FileReader("src/test/resources/facilities2.csv"));
		}
		catch (FileNotFoundException e) {
			new RuntimeException("Unable to load file ''", e);
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Room> getAll() {
		return roomRepo.getAll().values();
	}
	
//	@GET
//	@Path("/xml")
//	@Produces(MediaType.APPLICATION_XML)
//	public Collection<Room> getAllXml() {
//		return roomRepo.getAll().values();
//	}
	
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     * @throws FileNotFoundException 
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Room getIt(@PathParam("id") String id) throws FileNotFoundException { 	
        return roomRepo.getByLocation(id);
    }
}
