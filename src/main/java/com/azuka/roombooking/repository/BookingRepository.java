package com.azuka.roombooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.azuka.roombooking.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
	@Query(value = "SELECT * FROM booking WHERE status = :status", nativeQuery = true)
	List<Booking> getBookingListByStatus(@Param("status") Integer status);

	@Modifying
	@Query(value = "UPDATE booking b set b.status = ? where b.id_booking = ?", 
	  nativeQuery = true)
	Booking updateBookingStatus(Integer status, Integer id_booking);
}
