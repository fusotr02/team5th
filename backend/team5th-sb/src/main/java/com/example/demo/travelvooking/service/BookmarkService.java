package com.example.demo.travelvooking.service;

	import java.time.LocalDateTime;
	import java.util.List;
	import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.example.demo.travelvooking.dto.BookmarkRequest;
	import com.example.demot.travelvooking.dto.BookmarkResponseDTO;
	import com.example.demo.travelvooking.model.Bookmark;
	import com.example.demo.travelvooking.repository.BookmarkRepository;

	@Service
	public class BookmarkService {

	    @Autowired
	    private BookmarkRepository bookmarkRepository; // ← リポジトリを自動注入（DBアクセスのため）
	    
	    @Autowired
	    private UserRepository userRepository; //後で、インポートする
	    
	    @Autowired
	    private HotelRepository hotelRepository; //後で、インポートする

	    // ブックマークを登録する
	    public BookmarkResponseDTO addBookmark(BookmarkRequestDTO dto) {
	        User user = userRepository.findById(dto.getUserId()) //後で、インポートする
	            .orElseThrow(() -> new IllegalArgumentException("ユーザーが見つかりません"));
	        Hotel hotel = hotelRepository.findById(dto.getHotelId()) //後で、インポートする
	            .orElseThrow(() -> new IllegalArgumentException("ホテルが見つかりません"));
	        
	        Bookmark bookmark = new Bookmark();
	        bookmark.setUser(user);
	        bookmark.setHotel(hotel);
	        bookmark.setRegisteredAt(LocalDateTime.now());
	        
	        Bookmark saved = bookmarkRepository.save(bookmark);
	        return convertToResponseDTO(saved);

	    // 特定のユーザーのブックマーク一覧を取得
	    public List<Bookmark> getBookmarksByUserId(int userId) {
	    	List<Bookmark> bookmarks = bookmarkRepository.findByUserId(userId);
	        return bookmarks.stream()
	                .map(this::convertToResponseDTO)
	                .collect(Collectors.toList()); //?
	    }

	    // 特定のブックマーク（ID指定）を取得
	    public Optional<Bookmark> getBookmarkById(int id) {
	    	return bookmarkRepository.findById(id)
	                .map(this::convertToResponseDTO);
	    }

	    // ブックマークを削除する
	    public void deleteBookmark(int id) {
	        bookmarkRepository.deleteById(id); // ← 指定されたIDのブックマークを削除
	    }

	    // 特定ユーザー＆ホテルのブックマークを検索（存在チェックなどに使える）
	    public Optional<Bookmark> getByUserIdAndHotelId(int userId, int hotelId) {
	    	return bookmarkRepository.findByUserIdAndHotelId(userId, hotelId)
	                .map(this::convertToResponseDTO);
	    }
	    
	    // Bookmark → BookmarkResponseDTO に変換
	    private BookmarkResponseDTO convertToResponseDTO(Bookmark bookmark) {
	        BookmarkResponseDTO dto = new BookmarkResponseDTO();
	        dto.setBookmarkId(bookmark.getBookmarkId());
	        dto.setHotelId(bookmark.getHotel().getHotelId()); //原因：Hotel.javaのゲッター使用
	        dto.setHotelName(bookmark.getHotel().getHotelName()); //原因：Hotel.javaのゲッター使用
	        dto.setHotelImageUrl(bookmark.getHotel().getImageUrl()); //原因：Hotel.javaのゲッター使用
	        dto.setRegisteredAt(bookmark.getRegisteredAt());
	        return dto;
	    }
	}
}