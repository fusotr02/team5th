package com.example.demo.travelvooking.service;

import org.springframework.stereotype.Service;

import com.example.demo.travelvooking.dto.ReservationRequest;
import com.example.demo.travelvooking.dto.ReservationResponseDTO;
import com.example.demo.travelvooking.dto.ReservationUpdateRequest;
import com.example.demo.travelvooking.model.Reservation;
import com.example.demo.travelvooking.repository.ReservationRepository;

@Service
public class ReservationService {
	
	private ReservationRepository reservationRepository;
	
	private ReservationRequest convertToRequest(Reservation res) {
		ReservationRequest rr=new ReservationRequest();
		rr.setId(res.getId());
		rr.setUser_id(res.getUser_id());
		rr.setHotel_id(res.getHotel_id());
		rr.setCheckin_date(res.getCheckin_date());
		rr.setCheckout_date(res.getCheckout_date());
		rr.setPeople(res.getPeople());
		rr.setRooms(res.getRooms());
		rr.setStatus(res.getStatus());
		rr.setReservation_date(res.getReservation_date());
		return rr;			
	}
	
	private ReservationUpdateRequest convertToUpdateRequest(Reservation res) {
		ReservationUpdateRequest rur=new ReservationUpdateRequest();
		rur.setCheckin_date(res.getCheckin_date());
		rur.setCheckout_date(res.getCheckout_date());
		rur.setPeople(res.getPeople());
		rur.setRooms(res.getRooms());
		rur.setStatus(res.getStatus());
		return rur;
	}
	
	private ReservationResponseDTO convertToResponce(Reservation res) {
		ReservationResponseDTO rrdto=new ReservationResponseDTO();
		return rrdto;
	}
	
	
	 

}
