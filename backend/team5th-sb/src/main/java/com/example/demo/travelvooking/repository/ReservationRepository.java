package com.example.demo.travelvooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.travelvooking.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long>{

}
