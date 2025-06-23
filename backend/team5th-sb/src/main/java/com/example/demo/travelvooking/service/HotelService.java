package com.example.demo.travelvooking.service;

@Service
@RequiredArgsConstructor

public class HotelService {
	
	private final HotelRepository hotelRepository;
	
	public List<HotelResponse> getAllHotels(){
		return hotelRepository.findAii().stream()
				.map(this::convertToResponse)
				.collect(Collectors.toList());
	}
	
	public HotelRespones getHotelByID(Long id) {
		Hotel hotel = hotelRepository.findById(id)
				.orElseThrow(()->new RuntimeException("Hotel not found"));
		return convertToRespones(hotel);
	}
	
	private HotelRespones convertToResponse(Hotel hotel) {
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
