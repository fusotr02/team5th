package com.example.demo.travelvooking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class HotelResponse {
	private Long id;
	private String name;
	private double price;
	private String location;
	private String imageUrl;
	private String description;   //ホテル説明
}
