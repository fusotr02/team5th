package com.example.demo.travelvooking.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.travelvooking.dto.HotelResponse;
import com.example.demo.travelvooking.model.Hotel;
import com.example.demo.travelvooking.repository.HotelRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class HotelService {
	
	private final HotelRepository hotelRepository;
	
	
	public List<HotelResponse> getAllHotels(){
		return hotelRepository.findAll().stream()
				.map(this::convertToResponse)
				.collect(Collectors.toList());
	}
	
	public HotelResponse getHotelByID(Long id) {
		Hotel hotel = hotelRepository.findById(id)
				.orElseThrow(()->new RuntimeException("Hotel not found"));
		return convertToResponse(hotel);
	}

	public List<HotelResponse> searchHotels(String name, String region) {
	    List<Hotel> hotels;

	    if ((name == null || name.isEmpty()) && (region == null || region.isEmpty())) {
	        hotels = hotelRepository.findAll();
	    } else if (name != null && !name.isEmpty() && (region == null || region.isEmpty())) {
	        hotels = hotelRepository.findByNameContainingOrAddressContainingOrDescriptionContaining(name, name, name);
	    } else if ((name == null || name.isEmpty()) && region != null && !region.isEmpty()) {
	        hotels = hotelRepository.findByRegion(region);
	    } else {
	        hotels = hotelRepository.findByNameContainingOrAddressContainingOrDescriptionContainingAndRegion(name, name, name, region);
	    }

	    return hotels.stream()
	            .map(this::convertToResponse)
	            .collect(Collectors.toList());
	}
	
	private HotelResponse convertToResponse(Hotel hotel) {
		return new HotelResponse(
                hotel.getId(),
                hotel.getName(),
                hotel.getPrice(),
                hotel.getLocation(),
                hotel.getImageUrl(),
                hotel.getDescription()
        );
	}
}
