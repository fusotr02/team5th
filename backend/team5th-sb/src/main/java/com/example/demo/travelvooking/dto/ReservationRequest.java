package com.example.demo.travelvooking.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ReservationRequest {
	private Long userId; //ユーザーID
    private Long hotelId;
    private Date checkin_date;
    private Date checkout_date;
	private Integer people;
	private Integer rooms;

}
