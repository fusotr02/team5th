package com.example.demo.travelvooking.model;

	import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Data;

	@Entity
	@Data
	@Table(name = "bookmarks")
	public class Bookmark {
		 @Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    @Column(name = "bookmark_id")
		    private Integer bookmarkId;
		 
		 @ManyToOne
		    @JoinColumn(name = "user_id", nullable = false)
		    private User user; // 外部キー：ユーザー
		 
		 @ManyToOne
		    @JoinColumn(name = "hotel_id", nullable = false)
		    private Hotel hotel; // 外部キー：ホテル
		 
		 @Column(name = "registered_at", nullable = false)
		 private LocalDateTime registeredAt;// 登録日：現在時刻がデフォルト
	}