package com.azuka.roombooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.azuka.roombooking.model.Booking;
import com.azuka.roombooking.service.BookingService;

@Controller
public class BookingController {
	
	private BookingService bookingService;
	
	@Autowired
	public void setBookingService(BookingService bookingService) {
		this.bookingService = bookingService;
	}
	
	@RequestMapping("/history")
	public String history(Model model) {
		model.addAttribute("booking", bookingService.bookingList());
		return "dashboard/history";
	}
	
	@RequestMapping(value = "/booking/process", method = RequestMethod.POST)
	public String book(Model model, Booking booking) {
		model.addAttribute("booking", bookingService.addBooking(booking));
		return "redirect:/";
	}
	
}
