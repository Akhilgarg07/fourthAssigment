package com.nagarro.assignmentFour.controller;

import java.util.Date;
import java.util.List;
import org.springframework.web.bind.annotation.InitBinder;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.text.SimpleDateFormat;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import com.nagarro.assignmentFour.entity.Flight;
import com.nagarro.assignmentFour.service.FlightDetailsEntered;
import org.springframework.web.bind.WebDataBinder;

@Controller
public class FlightCont {
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class,"flightDate",new CustomDateEditor(dateFormat, false));
	}
	
	 @RequestMapping(value ="/flightSearch" , method=RequestMethod.POST)
		public ModelAndView flightSearch(@Valid @ModelAttribute("flightDetails")FlightDetailsEntered flightDetails,BindingResult result){
			
			ModelAndView modelAndView =new ModelAndView("flightSearch");
			if(result.hasErrors())
			{ 
				System.err.println(result);
				return modelAndView ;
			}
			List<Flight> listOfMatchingFlights= flightDetails.getListOfMatchingFlights();
			for(Flight f:listOfMatchingFlights) {
				System.out.println(f.getValid_till());
			}
			modelAndView = new ModelAndView("flightList");
			modelAndView.addObject("list", listOfMatchingFlights);
			return modelAndView ;
		}

}
