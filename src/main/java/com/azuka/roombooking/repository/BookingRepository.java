package com.azuka.roombooking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.azuka.roombooking.model.Booking;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Integer> {
	
}
