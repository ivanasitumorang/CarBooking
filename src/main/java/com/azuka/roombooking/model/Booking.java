package com.azuka.roombooking.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idBooking;
	private Integer idRoom;
	private Integer capacity;
	private String roomName;
	private Integer status;
	private String statusString;
	private Date date;
	
	public Integer getIdBooking() {
		return idBooking;
	}
	public void setIdBooking(Integer idBooking) {
		this.idBooking = idBooking;
	}
	public Integer getIdRoom() {
		return idRoom;
	}
	public void setIdRoom(Integer idRoom) {
		this.idRoom = idRoom;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public void setStatusString(Integer status) {
		switch (status) {
		case 1 :
			this.statusString = "Waiting";
			break;
		
		case 2 :
			this.statusString = "Accept";
			break;
		
		case 3 :
			this.statusString = "Decline";
			break;
		}		
	}
	
	public String getStatusString() {
		return statusString;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
}
