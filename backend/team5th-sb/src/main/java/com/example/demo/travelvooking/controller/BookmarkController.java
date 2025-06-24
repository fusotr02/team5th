package com.example.demo.travelvooking.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.travelvooking.dto.BookmarkRequestDTO;
import com.example.demo.travelvooking.dto.BookmarkResponseDTO;
import com.example.demo.travelvooking.repository.BookmarkRepository;
import com.example.demo.travelvooking.service.BookmarkService;

@RestController
@RequestMapping("api/bookmark")
public class BookmarkController {

	    @Autowired
	    private BookmarkService bookmarkService;

	    // 🔹 特定ユーザーのブックマーク一覧取得
	    @GetMapping("/user/{userId}")
	    public List<BookmarkResponseDTO> getBookmarksByUserId(@PathVariable int userId) {
	        return bookmarkService.getBookmarksByUserId(userId);
	    }
	    
	    // 🔹 ブックマーク登録（ハートON）
	    @PostMapping
	    public BookmarkResponseDTO addBookmark(@RequestBody BookmarkRequestDTO dto) {
	        return bookmarkService.addBookmark(dto);
	    }

	    // 🔹 ブックマーク削除（ハートOFF）
	    @DeleteMapping("/{bookmarkId}")
	    public void deleteBookmark(@PathVariable int bookmarkId) {
	        bookmarkService.deleteBookmark(bookmarkId);
	    }
	    
	    // 🔹 ユーザー＆ホテル指定でブックマーク取得（すでにあるかどうか確認する用）
	    @GetMapping("/exists")
	    public BookmarkResponseDTO checkBookmarkExists(@RequestParam int userId,@RequestParam int hotelId) {
	        return bookmarkService.getByUserIdAndHotelId(userId, hotelId)
	            .orElse(null); // 見つからない場合はnullを返す（Vueでチェック可能）
	    }
	}
}