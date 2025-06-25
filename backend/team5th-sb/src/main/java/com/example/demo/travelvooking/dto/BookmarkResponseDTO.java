package com.example.demo.travelvooking.dto;
import java.time.LocalDateTime;

public class BookmarkResponseDTO {

		private Integer bookmarkId; //ブックマークID
	    private LocalDateTime registeredAt; //ブックマーク登録日
	    
	    // ホテル情報（他テーブルから取得）
	    private Long hotelId; //ホテルID
	    private String hotelName; //ホテル名
	    private String hotelimageUrl; //ホテル画像
		
	    public Integer getBookmarkId() {
			return bookmarkId;
		}
		public void setBookmarkId(Integer bookmarkId) {
			this.bookmarkId = bookmarkId;
		}
		public LocalDateTime getRegisteredAt() {
			return registeredAt;
		}
		public void setRegisteredAt(LocalDateTime registeredAt) {
			this.registeredAt = registeredAt;
		}
		public Long getHotelId() {
			return hotelId;
		}
		public void setHotelId(Long hotelId) {
			this.hotelId = hotelId;
		}
		public String getHotelName() {
			return hotelName;
		}
		public void setHotelName(String hotelName) {
			this.hotelName = hotelName;
		}
		public String getHotelimageUrl() {
			return hotelimageUrl;
		}
		public void setHotelimageUrl(String hotelimageUrl) {
			this.hotelimageUrl = hotelimageUrl;
		}	    
}
