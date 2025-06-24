package com.example.demo.travelvooking.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.travelvooking.dto.ReservationRequest;
import com.example.demo.travelvooking.dto.ReservationResponseDTO;
import com.example.demo.travelvooking.dto.ReservationUpdateRequest;
import com.example.demo.travelvooking.model.Reservation;
import com.example.demo.travelvooking.model.User;
import com.example.demo.travelvooking.repository.HotelRepository;
import com.example.demo.travelvooking.repository.ReservationRepository;
import com.example.demo.travelvooking.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationService {
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private HotelRepository hotelRepository;
	
	
	public List<ReservationResponseDTO> getReservationByUser(User user){
		return reservationRepository.findByUser(user).stream()
				.map(this::convertToResponce).collect(Collectors.toList());
	}
	
	public ReservationResponseDTO getReservationById(Long id) {
		Reservation res=reservationRepository.findById(id).orElseThrow(()->new RuntimeException("Reservation not found"));
		return convertToResponce(res);
	}
	
	
	
	private ReservationRequest convertToRequest(Reservation res) {
		ReservationRequest rr=new ReservationRequest();
		rr.setId(res.getId());
		rr.setUser_id(res.getUser());
		rr.setHotel_id(res.getHotel());
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
		rrdto.setId(res.getId());
		rrdto.setUser(res.getUser());
		rrdto.setHotel(res.getHotel());
		rrdto.setCheckin_date(res.getCheckin_date());
		rrdto.setCheckout_date(res.getCheckout_date());
		rrdto.setPeople(res.getPeople());
		rrdto.setRooms(res.getRooms());
		rrdto.setStatus(res.getStatus());
		rrdto.setReservation_date(res.getReservation_date());
		return rrdto;
	}
	
	
	 

}
