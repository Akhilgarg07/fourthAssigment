package com.nagarro.assignmentFour.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.nagarro.assignmentFour.comparator.FlightDurationComparator;
import com.nagarro.assignmentFour.comparator.FlightPriceComparator;
import com.nagarro.assignmentFour.entity.Flight;

public class FlightDetailsEntered {
	private String depLoc ;
	private String arrLoc ;
	private Date flightDate ;
	private String flightClass ;
	private int outputPreference ;
	
	public String getDepLoc() {
		return depLoc;
	}
	public void setDepLoc(String depLoc) {
		this.depLoc = depLoc;
	}
	public String getArrLoc() {
		return arrLoc;
	}
	public void setArrLoc(String arrLoc) {
		this.arrLoc = arrLoc;
	}
	public Date getFlightDate() {
		return flightDate;
	}
	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
	}
	public String getFlightClass() {
		return flightClass;
	}
	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}
	public int getOutputPreference() {
		return outputPreference;
	}
	public void setOutputPreference(int outputPreference) {
		this.outputPreference = outputPreference;
	}
	
	public List<Flight> getListOfMatchingFlights(){
		ArrayList<Flight> matchingFlights = new ArrayList<Flight>();
		
		
		for (Flight flight : FlightService.allFlights) {
			if (flight.getDep_loc().equalsIgnoreCase(getDepLoc())
					&& flight.getArr_loc().equalsIgnoreCase(getArrLoc())
					&& flight.getFlight_class().equalsIgnoreCase(getFlightClass())
					&& (getFlightDate().compareTo(flight.getValid_till()) <= 0)
					&& flight.isSeat_availability())
				matchingFlights.add(flight);
		}
			
		if (getOutputPreference()==1)
			Collections.sort(matchingFlights, new FlightPriceComparator());
		else
			Collections.sort(matchingFlights, new FlightDurationComparator());
		
		return matchingFlights;
	}
}
