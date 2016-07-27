package com.github.gerlof85.dojo.mrrs;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class ReadFile {

			public StringBuilder ReadCSVFile(String fileLoc) throws FileNotFoundException{
				String fileName = "src/test/resources/facilities.csv";
				StringBuilder bldr = new StringBuilder();
		        String line = null; // This will reference one line at a time
				
				if (fileLoc.length() > 1 ) {  //indien niet leeg, gebruik meegegeven locatie
					fileName = fileLoc;
				}
				
		        try {
		            // FileReader reads text files in the default encoding.
		            FileReader fileReader = 
		                new FileReader(fileName);

		            // Always wrap FileReader in BufferedReader.
		            BufferedReader bufferedReader = 
		                new BufferedReader(fileReader);

		            while((line = bufferedReader.readLine()) != null) {
		                bldr.append(line);
		                bldr.append("\n");
		            }   

		            // Always close files.
		            bufferedReader.close();         
		        }
		        catch(FileNotFoundException ex) {
		        	//System.err.println("FileNotFoundException: " + ex.getMessage());
		        	throw ex;
		        	//System.out.println("Unable to open file '" + fileName + "'");                
		        }
		        catch(IOException ex) {
		            System.out.println(
		                "Error reading file '" 
		                + fileName + "'");                  
		            // Or we could just do this: ex.printStackTrace();
		        }
				
				return bldr;
			}
			
}
