package com.nagarro.assignmentFour.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "flights")
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String flight_no;

	private String dep_loc;

	private String arr_loc;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	private Date valid_till;

	private int flight_time;

	private double flight_dur;

	private int fare;

	private boolean seat_availability;

	private String flight_class;

	public Flight(String flightNo, String depLoc, String arrLoc, int fare, Date validTill, int flightTime,
			Double flightDuration, boolean seatAvailability, String flightClass) {
		super();
		this.flight_no = flightNo;
		this.dep_loc = depLoc;
		this.arr_loc = arrLoc;
		this.valid_till = validTill;
		this.flight_time = flightTime;
		this.flight_dur = flightDuration;
		this.seat_availability = seatAvailability;
		this.flight_class = flightClass;
		if (flightClass.equalsIgnoreCase("EB"))
			fare = 140 * fare / 100;
		this.fare = fare;
	}

	public Flight() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSeat_availability(boolean seat_availability) {
		this.seat_availability = seat_availability;
	}

	public String getFlight_no() {
		return flight_no;
	}

	public void setFlight_no(String flight_no) {
		this.flight_no = flight_no;
	}

	public String getDep_loc() {
		return dep_loc;
	}

	public void setDep_loc(String dep_loc) {
		this.dep_loc = dep_loc;
	}

	public String getArr_loc() {
		return arr_loc;
	}

	public void setArr_loc(String arr_loc) {
		this.arr_loc = arr_loc;
	}

	public Date getValid_till() {
		return valid_till;
	}

	public void setValid_till(Date valid_till) {
		this.valid_till = valid_till;
	}

	public int getFlight_time() {
		return flight_time;
	}

	public void setFlight_time(int flight_time) {
		this.flight_time = flight_time;
	}

	public double getFlight_dur() {
		return flight_dur;
	}

	public void setFlight_dur(double flight_dur) {
		this.flight_dur = flight_dur;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	public boolean isSeat_availability() {
		return seat_availability;
	}

	public String getFlight_class() {
		return flight_class;
	}

	public void setFlight_class(String flight_class) {
		this.flight_class = flight_class;
	}

}
