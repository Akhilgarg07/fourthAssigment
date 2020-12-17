package com.nagarro.assignmentFour.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.assignmentFour.constants.Constants;
import com.nagarro.assignmentFour.entity.Flight;
import com.nagarro.assignmentFour.repository.FlightRepo;

@Service
public class FlightService {

	@Autowired
	private FlightRepo fdto;

	String line = "";
	public static List<Flight> allFlights = new ArrayList<Flight>();

	public void saveFlightData() {

		File directory = new File(Constants.DIRECTORY);
		File files[] = directory.listFiles();
		for (File file : files) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				line = br.readLine();
				while ((line = br.readLine()) != null) {
					String[] data = line.split("\\|");
					Flight flight = new Flight();
					flight.setFlight_no(data[0]);
					flight.setDep_loc(data[1]);
					flight.setArr_loc(data[2]);
					try {
						flight.setValid_till(Constants.DATEFORMAT.parse(data[3]));
					} catch (ParseException e) {
						e.printStackTrace();
					}
					flight.setFlight_time(Integer.parseInt(data[4]));
					flight.setFlight_dur(Double.parseDouble(data[5]));
					flight.setFare(Integer.parseInt(data[6]));
					String seatAvailable = data[7];
					if (seatAvailable.charAt(0) == 'Y')
						flight.setSeat_availability(true);
					else
						flight.setSeat_availability(false);
					flight.setFlight_class(data[8]);
					fdto.save(flight);
					allFlights.add(flight);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
