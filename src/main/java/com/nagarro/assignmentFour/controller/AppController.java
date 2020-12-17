package com.nagarro.assignmentFour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.nagarro.assignmentFour.constants.Constants;
import com.nagarro.assignmentFour.entity.User;
import com.nagarro.assignmentFour.service.FlightService;
import com.nagarro.assignmentFour.service.UserRegisterService;

@Controller
public class AppController {

	@Autowired
	private UserRegisterService userRegister;;

	@Autowired
	private FlightService flightService;

	@GetMapping("")
	public String viewHomePage() {
		return Constants.INDEX;
	}

	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		return Constants.SIGNUP;
	}

	@PostMapping("/register")
	public String processRegister(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		userRegister.userRepoSave(user);

		return Constants.REGISTERSUCCESS;
	}

	@GetMapping("/flightSearch")
	public String viewFlightSearch() {
		flightService.saveFlightData();
		return Constants.FLIGHTSEARCH;
	}

}
