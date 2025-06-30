package com.example.demo.travelvooking.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.travelvooking.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Long>{
	
	// キーワード検索
    List<Hotel> findByNameContainingOrlocationContainingOrDescriptionContaining(String name, String location, String description);

    // 地域で絞り込み
    List<Hotel> findByRegion(String region);
    
    
    // キーワード + 地域 の複合検索（追加）
    List<Hotel> findByNameContainingOrlocationContainingOrDescriptionContainingAndRegion(
            String name, String location, String description, String region);

    //部分一致で検索可能        
    List<Hotel> findByLocationContaining(String location);
}
