package com.nagarro.assignmentFour.comparator;

import java.util.Comparator;

import com.nagarro.assignmentFour.entity.Flight;


public class FlightDurationComparator implements Comparator<Flight> {

	@Override
	public int compare(Flight a, Flight b) {
		double x  = a.getFlight_dur()-b.getFlight_dur() ;
		if (x<0)
		return -1;
		else if (x>0)
			return 1 ;
		else
			return 0;
			
	}

}
