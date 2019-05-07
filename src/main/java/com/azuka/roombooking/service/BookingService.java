package com.azuka.roombooking.service;

import java.util.List;

import com.azuka.roombooking.model.Booking;

public interface BookingService {
	List<Booking> bookingList();
	
	Booking addBooking(Booking booking);
}
