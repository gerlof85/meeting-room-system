package com.github.gerlof85.dojo.mrrs.services;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import static org.junit.Assert.*;

import javax.management.RuntimeErrorException;

import org.junit.Test;

public class RoomServiceTest {
	
	@Test
	public void roomSericeTest() throws Exception {
		String jsonString = "{\"name\":\"Rotterdam\",\"location\":\"1.08\",\"capacity\":12,\"facilities\":[{\"name\":\"Beamer\"},{\"name\":\"Computer\"},{\"name\":\"Table\"}]}";
		
		assertEquals(jsonString,roomServiceCall("1.08"));
	}

	//service voor ophalen JSon string aan de hand van locatiecode
	public static String roomServiceCall(String location) {
		String output = null;
		try {

			Client client = Client.create();
			
			WebResource webResource = client.resource("http://localhost:8080/webapi/rooms/" + location);
			
			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
						
			if (response.getStatus() != 200){
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}
			
			output = response.getEntity(String.class);
//			System.out.println("Output from server...   \n");
//			System.out.println(output);
				
		  } catch (Exception e) {

			e.printStackTrace();

		  }
		return output;
	}
	
}
