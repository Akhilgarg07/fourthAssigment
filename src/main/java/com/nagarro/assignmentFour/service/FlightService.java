package com.nagarro.assignmentFour.service;

import com.nagarro.assignmentFour.AppContextUtil.AppContextUtil;
import com.nagarro.assignmentFour.controller.FlightController;
import com.nagarro.assignmentFour.dao.FlightDao;
import com.nagarro.assignmentFour.entity.Airline;
import com.nagarro.assignmentFour.entity.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import org.hibernate.Session;
import java.text.SimpleDateFormat;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Service
public class FlightService implements Runnable{
	File dir = new File("C:\\Users\\Akhil\\Desktop\\assignmentFour\\CSV");
	static FlightDao flightDao = (FlightDao) AppContextUtil.context.getBean("flightDao");
	
	public void run() {
		File files[] = dir.listFiles();
		ArrayList<String> listofFileNames = new ArrayList<String>();
		for (File file : files) {
			Airline airline = FlightController.readFile(file);
			flightDao.saveAirline(airline);
		}
		
	}
}