package com.example.demo.travelvooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.travelvooking.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long>{
	
	List<Reservation> findByUser(int userId);
	
	void deleteById (Reservation reservation);

}
