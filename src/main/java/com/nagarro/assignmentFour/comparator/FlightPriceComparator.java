package com.nagarro.assignmentFour.comparator;

import java.util.Comparator;

import com.nagarro.assignmentFour.entity.Flight;

public class FlightPriceComparator implements Comparator<Flight>
{
	@Override
	public int compare(Flight arg0, Flight arg1) {
		return arg0.getFare()-arg1.getFare();
	}
}