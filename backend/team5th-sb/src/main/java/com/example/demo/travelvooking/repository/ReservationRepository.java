package com.example.demo.travelvooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.travelvooking.model.Reservation;
import com.example.demo.travelvooking.model.User;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long>{
	
	List<Reservation> findByUser(User user);
	
	void deleteById (Reservation reservation);

}
