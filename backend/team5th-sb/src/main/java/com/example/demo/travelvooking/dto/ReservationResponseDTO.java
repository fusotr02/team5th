package com.example.demo.travelvooking.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class ReservationResponseDTO {
	    private Long id;
	    private Date checkin_date;
	    private Date checkout_date;
	    private Integer people;
	    private Integer rooms;
	    private String status;
	    private LocalDateTime reservation_date;

	    private Long hotelId; //ホテルID
	    private String hotelName; //ホテル名
	    private String hotelimageUrl; //ホテル画像
	    
	    private Long userId;
	    private String userName;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
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
		public Integer getPeople() {
			return people;
		}
		public void setPeople(Integer people) {
			this.people = people;
		}
		public Integer getRooms() {
			return rooms;
		}
		public void setRooms(Integer rooms) {
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
		public Long getHotelId() {
			return hotelId;
		}
		public void setHotelId(Long hotelId) {
			this.hotelId = hotelId;
		}
		public String getHotelName() {
			return hotelName;
		}
		public void setHotelName(String hotelName) {
			this.hotelName = hotelName;
		}
		public String getHotelimageUrl() {
			return hotelimageUrl;
		}
		public void setHotelimageUrl(String hotelimageUrl) {
			this.hotelimageUrl = hotelimageUrl;
		}
		public Long getUserId() {
			return userId;
		}
		public void setUserId(Long userId) {
			this.userId = userId;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
	    
	    
}
