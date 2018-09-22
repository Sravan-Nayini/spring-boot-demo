package com.tech.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tech.entities.User;
import com.tech.service.TaskService;
import com.tech.service.UserService;

@Controller
public class ProfileController {

	@Autowired
	private UserService userService;
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/profile")
	public String showProfilePage(Model model,Principal principal)
	{
		String email=principal.getName();
		User user=userService.findOne(email);
		model.addAttribute("tasks", taskService.findUserTask(user));
		return "views/profile";
	}
	
}
