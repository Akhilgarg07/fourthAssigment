package com.nagarro.assignmentFour.dao;

import java.util.List;

import com.nagarro.assignmentFour.entity.Airline;
import com.nagarro.assignmentFour.entity.Flight;

public interface FlightDao {
		public void saveAirline(Airline airline);
		public List<Flight> getFlights();
//		public void deleteAirline(String airlineName);

}
