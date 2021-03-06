package com.nagarro.assignmentFour.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.nagarro.assignmentFour.comparator.FlightDurationComparator;
import com.nagarro.assignmentFour.comparator.FlightPriceComparator;
import com.nagarro.assignmentFour.service.FlightService;

public class FlightInputDetails {
	private String depLoc;
	private String arrLoc;
	private Date flightDate;
	private String flightClass;
	private int outputPreference;

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
}
