 package com.TinyTreasures.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.TinyTreasures.global.GlobalData;
import com.TinyTreasures.model.User;
import com.TinyTreasures.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("registerRequest",new User());
		return "Register";
	}
	
	@GetMapping("/login")
	public String login(Model model,User user) {
		GlobalData.cart.clear();
		model.addAttribute("loginRequest",user);
		return "Login";
	}
	
	@PostMapping("/signup")
	public String signup(@ModelAttribute User user) {
		System.out.println("register request: "+user.getName());
		userService.RegisterUser(user);
		return user==null ? "error" : "redirect:/login";
	}
	
	
	@RequestMapping(value = {"/logout"})
    public String logoutDo(HttpServletRequest request,HttpServletResponse response){
		GlobalData.cart.clear();
		return "redirect:/login";
    }
	
	
}
