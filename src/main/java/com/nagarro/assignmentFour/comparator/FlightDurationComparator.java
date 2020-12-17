package com.nagarro.assignmentFour.comparator;

import java.util.Comparator;

import com.nagarro.assignmentFour.entity.Flight;

public class FlightDurationComparator implements Comparator<Flight> {

	@Override
	public int compare(Flight flight1, Flight flight2) {
		double x = flight1.getFlight_dur() - flight2.getFlight_dur();
		if (x < 0)
			return -1;
		else if (x > 0)
			return 1;
		else
			return 0;

	}

}
