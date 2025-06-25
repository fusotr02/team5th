package com.example.demo.travelvooking.dto;

import java.time.LocalDateTime;
import java.util.Date;

import com.example.demo.travelvooking.model.Hotel;
import com.example.demo.travelvooking.model.User;

public class ReservationResponseDTO {
	    private Long id;
	    private User user;
	    private Hotel hotel;
	    private Date checkin_date;
	    private Date checkout_date;
	    private int people;
	    private int rooms;
	    private String status;
	    private LocalDateTime reservation_date;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public Hotel getHotel() {
			return hotel;
		}
		public void setHotel(Hotel hotel) {
			this.hotel = hotel;
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
		public LocalDateTime getReservation_date() {
			return reservation_date;
		}
		public void setReservation_date(LocalDateTime reservation_date) {
			this.reservation_date = reservation_date;
		}
	    
		

}
