package com.nagarro.assignmentFour.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.assignmentFour.entity.User;
import com.nagarro.assignmentFour.repository.UserRepository;

@Service
public class UserRegisterService {

	@Autowired
	private UserRepository userRepo;

	public void userRepoSave(User user) {
		userRepo.save(user);
	}

}
