package com.nagarro.assignmentFour.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.assignmentFour.entity.FinalFlightResult;
import com.nagarro.assignmentFour.entity.Flight;

@Controller
public class FlightController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, "flightDate", new CustomDateEditor(dateFormat, false));
	}

	@PostMapping("/flightSearch")
	public ModelAndView flightSearch(@Valid @ModelAttribute("flightDetails") FinalFlightResult flightDetails,
			BindingResult result) {

		ModelAndView modelAndView = new ModelAndView("flightSearch");
		if (result.hasErrors()) {
			System.err.println(result);
			return modelAndView;
		}
		List<Flight> listOfMatchingFlights = flightDetails.getListOfMatchingFlights();
		modelAndView = new ModelAndView("flightList");
		modelAndView.addObject("list", listOfMatchingFlights);
		return modelAndView;
	}

}
