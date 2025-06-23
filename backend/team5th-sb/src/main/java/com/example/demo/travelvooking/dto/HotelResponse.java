package com.example.demo.travelvooking.dto;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class HotelResponse {
	private Long id;
	private String name;
	private int price;
	private String location;
	private String imageUrl;
	private String description;   //ホテル説明
}
