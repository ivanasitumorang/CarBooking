package com.azuka.roombooking.model;

import java.util.ArrayList;
import java.util.List;

public class BookingHistory {
	private List<Booking> bookingRecords;
	private static BookingHistory bookingHistory = null;
	
	private BookingHistory() {
		bookingRecords = new ArrayList<Booking>();
	}
	
	public static BookingHistory getInstance() {
		if (bookingHistory == null) {
			bookingHistory = new BookingHistory();
			return bookingHistory;
		} else return bookingHistory;
	}
	
	public String updateBooking(Booking booking) {
		for (int i=0; i<bookingRecords.size(); i++) {
			Booking b = bookingRecords.get(i);
			if(b.getIdBooking().equals(booking.getIdBooking())) {
				bookingRecords.set(i, booking);
				return "Update success";
			}
		}
		return "Update not success";
	}

	public List<Booking> getBookingRecords() {
		return bookingRecords;
	}
	
}
