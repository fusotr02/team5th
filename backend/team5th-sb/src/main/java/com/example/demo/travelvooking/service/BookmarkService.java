package com.example.demo.travelvooking.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.travelvooking.dto.BookmarkRequest;
import com.example.demo.travelvooking.dto.BookmarkResponseDTO;
import com.example.demo.travelvooking.model.Bookmark;
import com.example.demo.travelvooking.model.Hotel;
import com.example.demo.travelvooking.model.User;
import com.example.demo.travelvooking.repository.BookmarkRepository;
import com.example.demo.travelvooking.repository.HotelRepository;
import com.example.demo.travelvooking.repository.UserRepository;

@Service
public class BookmarkService {

	@Autowired
	private BookmarkRepository bookmarkRepository; // ← リポジトリを自動注入（DBアクセスのため）

	@Autowired
	private UserRepository userRepository; 

	@Autowired
	private HotelRepository hotelRepository; 

	// ブックマークを登録する
	public BookmarkResponseDTO addBookmark(BookmarkRequest dto) {
	        User user = userRepository.findById((long)dto.getUserId()) 
	            .orElseThrow(() -> new IllegalArgumentException("ユーザーが見つかりません"));
	        Hotel hotel = hotelRepository.findById((long)dto.getHotelId()) 
	            .orElseThrow(() -> new IllegalArgumentException("ホテルが見つかりません"));
	        
	        Bookmark bookmark = new Bookmark();
	        bookmark.setUser(user);
	        bookmark.setHotel(hotel);
	        bookmark.setRegisteredAt(LocalDateTime.now());
	        
	        Bookmark saved = bookmarkRepository.save(bookmark);
	        return convertToResponseDTO(saved);
	}
	        
	    // 特定のユーザーのブックマーク一覧を取得
	public List<BookmarkResponseDTO> getBookmarksByUserId(int userId) {
		User user = userRepository.findById((long) userId)
                .orElseThrow(() -> new IllegalArgumentException("ユーザーが見つかりません"));
        List<Bookmark> bookmarks = bookmarkRepository.findByUser(user);
        return bookmarks.stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

	// 特定のブックマーク（ID指定）を取得
	public Optional<BookmarkResponseDTO> getBookmarkById(int id) {
		return bookmarkRepository.findById(id)
				.map(this::convertToResponseDTO);
	}

	// ブックマークを削除する
	public void deleteBookmark(int id) {
		bookmarkRepository.deleteById(id); // ← 指定されたIDのブックマークを削除
	}

	// 特定ユーザー＆ホテルのブックマークを検索（存在チェックなどに使える）
	public Optional<Bookmark> getByUserIdAndHotelId(Long userId, Long hotelId) {
		User user = userRepository.findById((long) userId)
                .orElseThrow(() -> new IllegalArgumentException("ユーザーが見つかりません"));
        Hotel hotel = hotelRepository.findById((long) hotelId)
                .orElseThrow(() -> new IllegalArgumentException("ホテルが見つかりません"));
        return bookmarkRepository.findByUserAndHotel(user, hotel);
    }

	// Bookmark → BookmarkResponseDTO に変換
	private BookmarkResponseDTO convertToResponseDTO(Bookmark bookmark) {
		BookmarkResponseDTO dto = new BookmarkResponseDTO();
		dto.setBookmarkId(bookmark.getBookmarkId());
		dto.setHotelId(bookmark.getHotel().getId()); //getHotelIdになんでエラーでるの？これはどこのデータを取ってくるんだ？
		dto.setHotelName(bookmark.getHotel().getName()); //getHotelNameになんでエラーでるの？これはどこのデータを取ってくるんだ？
		dto.setHotelimageUrl(bookmark.getHotel().getImageUrl()); //setHotelImageUrlになんでエラーでるの？
		dto.setRegisteredAt(bookmark.getRegisteredAt());
		return dto;
	}
}