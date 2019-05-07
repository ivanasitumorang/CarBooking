package com.azuka.roombooking.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azuka.roombooking.model.Booking;

@Service
public class BookingDao implements BookingService {

	private EntityManagerFactory emf;
	
	@Autowired
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@Override
	public List<Booking> bookingList() {
		EntityManager em = emf.createEntityManager();
		return em.createQuery("from booking where status != 0", Booking.class).getResultList();
	}

	@Override
	public Booking addBooking(Booking booking) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Booking saved = em.merge(booking);
		em.getTransaction().commit();
		return saved;
	}

}
