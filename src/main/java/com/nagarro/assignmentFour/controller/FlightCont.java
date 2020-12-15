package com.nagarro.assignmentFour.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.assignmentFour.entity.Flight;
import com.nagarro.assignmentFour.service.FlightDetailsEntered;

@Controller
public class FlightCont {
	
	 @RequestMapping(value ="/flightSearch" , method=RequestMethod.POST)
		public ModelAndView flightSearch(@Valid @ModelAttribute("flightDetails")FlightDetailsEntered flightDetails,BindingResult result){
			
			ModelAndView modelAndView =new ModelAndView("flightSearch");
			if(result.hasErrors())
			{ 
				System.err.println(result);
				return modelAndView ;
			}
			List<Flight> listOfMatchingFlights= flightDetails.getListOfMatchingFlights();
			modelAndView = new ModelAndView("flightList");
			modelAndView.addObject("list", listOfMatchingFlights);
			return modelAndView ;
		}

}
