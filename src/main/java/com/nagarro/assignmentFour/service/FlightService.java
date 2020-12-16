package com.nagarro.assignmentFour.service;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.assignmentFour.dto.FlightDTO;
import com.nagarro.assignmentFour.entity.Flight;


@Service
public class FlightService {

	@Autowired
	private FlightDTO fdto;
	
	String line = "";
	static List<Flight> allFlights = new ArrayList<Flight>();
	public static final SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
	public void saveFlightData() {
		
		File dir = new File("C:\\Users\\Akhil\\Desktop\\readCSV\\readCSV\\CSV");
		File files[] = dir.listFiles();
		for(File file: files) {
		try {
			BufferedReader br = new BufferedReader(new FileReader
					(file));
			line = br.readLine();
			while((line=br.readLine())!=null) {
				String[] data = line.split("\\|");
				Flight f = new Flight();
				f.setFlight_no(data[0]);
				f.setDep_loc(data[1]);
				f.setArr_loc(data[2]);
				try {
					f.setValid_till(dateformat.parse(data[3]));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				f.setFlight_time(Integer.parseInt(data[4]));
				f.setFlight_dur(Double.parseDouble(data[5]));
				f.setFare(Integer.parseInt(data[6]));
				String b = data[7];
				if(b.charAt(0)=='Y')
					f.setSeat_availability(true);
				else
					f.setSeat_availability(false);
				f.setFlight_class(data[8]);
				fdto.save(f);
				allFlights.add(f);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		}
	}
}
