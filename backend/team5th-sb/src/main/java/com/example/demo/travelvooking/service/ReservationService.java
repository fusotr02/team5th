package com.example.demo.travelvooking.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.travelvooking.dto.ReservationRequest;
import com.example.demo.travelvooking.dto.ReservationResponseDTO;
import com.example.demo.travelvooking.dto.ReservationUpdateRequest;
import com.example.demo.travelvooking.model.Hotel;
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
	
	
	public List<ReservationResponseDTO> getReservationByUser(int userId){
		return reservationRepository.findByUser(userId).stream()
				.map(this::convertToResponse).collect(Collectors.toList());
	}
	
	public ReservationResponseDTO getReservationById(Long id) {
		Reservation res=reservationRepository.findById(id).orElseThrow(()->new RuntimeException("Reservation not found"));
		return convertToResponse(res);
	}
	
	public ReservationResponseDTO addReservation(ReservationRequest dto) {
		User user = userRepository.findById(dto.getUser_id()) //後で、インポートする
	            .orElseThrow(() -> new IllegalArgumentException("ユーザーが見つかりません"));
	    Hotel hotel = hotelRepository.findById(dto.getHotel_id()) //後で、インポートする
	            .orElseThrow(() -> new IllegalArgumentException("ホテルが見つかりません"));
	    Reservation res=new Reservation();
	    res.setUser(user);
	    res.setHotel(hotel);
	    res.setCheckin_date(dto.getCheckin_date());
		res.setCheckout_date(dto.getCheckout_date());
		res.setPeople(dto.getPeople());
		res.setRooms(dto.getRooms());
	    res.setReservation_date(LocalDateTime.now());
	    
	    Reservation saved=reservationRepository.save(res);
	    return convertToResponse(saved);
	}
	
	public ReservationResponseDTO updateReservation(Long id,ReservationUpdateRequest dto) {
		Reservation res=reservationRepository.findById(id)
				.orElseThrow(()->new IllegalArgumentException("予約が見つかりません"));
		res.setCheckin_date(dto.getCheckin_date());
		res.setCheckout_date(dto.getCheckout_date());
		res.setPeople(dto.getPeople());
		res.setRooms(dto.getRooms());
		
		Reservation saved=reservationRepository.save(res);
	    return convertToResponse(saved);
	}
	
	private ReservationResponseDTO convertToResponse(Reservation res) {
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
