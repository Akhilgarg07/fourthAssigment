package com.nagarro.assignmentFour.controller;

import java.io.File;
import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nagarro.assignmentFour.entity.Flight;
import com.nagarro.assignmentFour.entity.User;
import com.nagarro.assignmentFour.repository.UserRepository;
import com.nagarro.assignmentFour.service.FlightDetailsEntered;
import com.nagarro.assignmentFour.service.FlightService;
//import com.nagarro.assignmentFour.service.FlightService;
 
@Controller 
public class AppController {

	@Autowired
    private UserRepository userRepo;
	
	@Autowired
	private FlightService fs;
     
	@GetMapping("")
    public String viewHome() 
	{
		return "index";
	}
	
    @GetMapping("/home")
    public String viewHomePage() {
        return "index";
    }
    
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
    	model.addAttribute("user",new User());
    	return  "signup";
    }
    
    @PostMapping("/process_register")
    public String processRegister(User user) {
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	String encodedPassword = passwordEncoder.encode(user.getPassword());
    	user.setPassword(encodedPassword);
    	userRepo.save(user);
    	
    	return "register_success";
    }
    
    @GetMapping("/flightSearch")
    public String viewFlightSearch() {
        fs.saveFlightData();
        return "flightSearch";
    }
    
    
}
