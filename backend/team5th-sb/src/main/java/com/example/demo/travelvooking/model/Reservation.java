package com.example.demo.travelvooking.model;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="reservation")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@ManyToOne()
	@JoinColumn(name="user_id",nullable=false)
	private User user;
	
	@ManyToOne()
	@JoinColumn(name="hotel_id",nullable=false)
	private Hotel hotel;
	
	@Column(name="checkin_date",nullable=false)
	private Date checkin_date;
	
	@Column(name="checkout_date",nullable=false)
	private Date checkout_date;
	
	@Column(name="people",nullable=false)
	private int people;
	
	@Column(name="rooms",nullable=false)
	private int rooms;
	
	@Column(name="status",columnDefinition="VARCHAR(20) DEFAULT'予約済み'")
	private String status;
	
	@Column(name="reservation_date",columnDefinition="DATETIME DEFAULT'LocalDate.now()'")
	private LocalDate reservation_date;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public LocalDate getReservation_date() {
		return reservation_date;
	}

	public void setReservation_date(LocalDate reservation_date) {
		this.reservation_date = reservation_date;
	}

	

}
