package com.example.demo.travelvooking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Bookmark;

@Repository
public interface BookmarkRpository extends JpaRepository<Bookmark, Integer> {
	
		// 指定ユーザーのブックマーク一覧を取得
	    List<Bookmark> findByUser(User user);

	    // 指定ユーザーが特定ホテルをブックマークしているか確認
	    Optional<Bookmark> findByUserAndHotel(User user, Hotel hotel);

	    // 特定ユーザー・ホテルのブックマークを削除
	    void deleteByUserAndHotel(User user, Hotel hotel);

	}

}
