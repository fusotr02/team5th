package com.example.demo.travelvooking.dto;

public class BookmarkRequest {
	
		    private Long userId; //ユーザーID
		    private Integer hotelId; //ホテルID
			public Long getUserId() {
				return userId;
			}
			public void setUserId(Long userId) {
				this.userId = userId;
			}
			public Integer getHotelId() {
				return hotelId;
			}
			public void setHotelId(Integer hotelId) {
				this.hotelId = hotelId;
			}
		    		    
}