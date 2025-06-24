package com.example.demo.travelvooking.dto;

import java.time.LocalDate;
import java.util.Date;

public class ReservationRequest {
	private Long id;
    private int user_id;
    private int hotel_id;
    private Date checkin_date;
    private Date checkout_date;
    private int people;
    private int rooms;
    private String status;
    private LocalDate reservation_date;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}
	public Date getCheckin_date() {
		return checkin_date;
	}
	public void setCheckin_date(Date checkin_date) {
		this.checkin_date = checkin_date;
	}
	public Date getCheckout_date() {
		return checkout_date;
	}
	public void setCheckout_date(Date checkout_date) {
		this.checkout_date = checkout_date;
	}
	public int getPeople() {
		return people;
	}
	public void setPeople(int people) {
		this.people = people;
	}
	public int getRooms() {
		return rooms;
	}
	public void setRooms(int rooms) {
		this.rooms = rooms;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getReservation_date() {
		return reservation_date;
	}
	public void setReservation_date(LocalDate reservation_date) {
		this.reservation_date = reservation_date;
	}
	
	

}
