package com.azuka.roombooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
	/*
	 * @GetMapping("/")
	public String home() {
		return "dashboard/index";
	}
	 */
	
	
	
	@GetMapping("/tes")
	public String search() {
		return "dashboard/tes";
	}
	
	@GetMapping("/login")
	public String login() {
		return "dashboard/login";
	}
	
	/*
	 * 
	 @GetMapping("/process")
	public String booking() {
		return "dashboard/booking";
	}
	
	@GetMapping("/history")
	public String history() {
		return "dashboard/history";
	}
	 */
	
	@GetMapping("/access-denied")
	public String accessDenied() {
		return "/error/access-denied";
	}
}
