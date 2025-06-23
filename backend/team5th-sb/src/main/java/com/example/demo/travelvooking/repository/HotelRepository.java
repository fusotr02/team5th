package com.example.demo.travelvooking.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.travelvooking.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Long>{
	
	// キーワード検索
    List<Hotel> findByNameContainingOrAddressContainingOrDescriptionContaining(String name, String address, String description);

    // 地域で絞り込み
    List<Hotel> findByRegion(String region);
}
