package com.TinyTreasures.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.TinyTreasures.model.User;
import com.TinyTreasures.repo.UserRepository;

import org.springframework.stereotype.Service;


@Service
public class UserService {
	
	@Autowired
    private UserRepository userRepo;

    
    public String RegisterUser(User user) {
    	userRepo.save(user);
        return "user added to system ";
    }

}
