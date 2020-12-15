package com.nagarro.assignmentFour.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.nagarro.assignmentFour.entity.Airline;
import com.nagarro.assignmentFour.entity.Flight;

import org.hibernate.Query;

public class FlightDaoImpl implements FlightDao{
	HibernateTemplate template;  
	public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	}
	public void saveAirline(Airline airline){
		Session session=template.getSessionFactory().openSession();
	    session.beginTransaction();
	    session.save(airline);
	    session.getTransaction().commit();
	    session.close();
	}
	
	public List<Flight> getFlights(){
		return template.loadAll(Flight.class);
	}
}