package main.java.com.example.demo.travelvooking.controller;



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