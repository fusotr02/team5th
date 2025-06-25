package com.example.demo.travelvooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.travelvooking.dto.ReservationRequest;
import com.example.demo.travelvooking.dto.ReservationResponseDTO;
import com.example.demo.travelvooking.dto.ReservationUpdateRequest;
import com.example.demo.travelvooking.service.ReservationService;

@RestController
@RequestMapping("api/reservation")
public class ReservtionController {
	
	@Autowired
	private ReservationService reservationService;
	
	@GetMapping("/user/{userId}")
	public List<ReservationResponseDTO> getReservationByUserId(@PathVariable int userId){
		return reservationService.getReservationByUser(userId);
	}
	
	@GetMapping("/id/{id}")
	public ReservationResponseDTO getReservationById(Long id) {
		return reservationService.getReservationById(id);
	}
	
	@PostMapping
	public ReservationResponseDTO addReservation(@RequestBody ReservationRequest dto) {
		return reservationService.addReservation(dto);
	}
	
	@PostMapping("/update/{id}")
	public ReservationResponseDTO updateReservation(@PathVariable Long id,@RequestBody ReservationUpdateRequest dto) {
		return reservationService.updateReservation(id,dto);
	}
	
	

}
