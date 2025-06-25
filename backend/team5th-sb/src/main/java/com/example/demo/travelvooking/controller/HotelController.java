package com.example.demo.travelvooking.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.travelvooking.dto.HotelResponse;
import com.example.demo.travelvooking.service.HotelService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/hotels")

public class HotelController {
	 private final HotelService hotelService;

	    @GetMapping
	    public List<HotelResponse> getAllHotels() {
	        return hotelService.getAllHotels();
	    }

	    @GetMapping("/{id}")
	    public HotelResponse getHotelById(@PathVariable Long id) {
	        return hotelService.getHotelByID(id);
	    }
}
