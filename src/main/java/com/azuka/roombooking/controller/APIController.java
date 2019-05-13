package com.azuka.roombooking.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.azuka.roombooking.model.Booking;
import com.azuka.roombooking.repository.BookingRepository;
import com.azuka.roombooking.web.ResourceNotFoundException;

@RestController
@RequestMapping("/api")
public class APIController {
	
	@Autowired
    BookingRepository bookingRepository;
	
	@GetMapping("/booking/lists")
	public List<Booking> getAllBooking() {
	    return bookingRepository.getBookingListByStatus(1);
	}
	
	@PostMapping("/booking")
	public Booking createNote(@Valid @RequestBody Booking booking) {
	    return bookingRepository.save(booking);
	}
	
	@GetMapping("/booking/{id}")
	public Booking getBookingById(@PathVariable(value = "id") Integer bookingId) {
	    return bookingRepository.findById(bookingId)
	            .orElseThrow(() -> new ResourceNotFoundException("Booking", "idBooking", bookingId));
	}
	
	@PutMapping("/booking/{id}")
	public Booking updateBooking(@PathVariable(value = "id") Integer bookingId,
	                                        @Valid Integer status) {

		Booking booking = bookingRepository.findById(bookingId)
	            .orElseThrow(() -> new ResourceNotFoundException("Booking", "idBooking", bookingId));

	    booking.setStatus(status);
	    booking.setStatusString(status);
	    return bookingRepository.save(booking);
	}
	
	
}
