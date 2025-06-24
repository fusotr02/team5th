package com.example.demo.travelvooking.dto;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BookmarkResponseDTO {

		private Integer bookmarkId; //ブックマークID
	    private LocalDateTime registeredAt; //ブックマーク登録日
	    
	    // ホテル情報（他テーブルから取得）
	    private Integer hotelId; //ホテルID
	    private String hotelName; //ホテル名
	    private String hotelimageUrl; //ホテル画像
	}
}