package com.nagarro.assignmentFour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.nagarro.assignmentFour.entity.User;
import com.nagarro.assignmentFour.repository.UserRepository;
import com.nagarro.assignmentFour.service.FlightService;
 
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
