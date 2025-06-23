package com.example.demo.travelvooking.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Hotel {
	@ID
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "ホテルID")
    private Long id;

    @Column(name = "ホテル名", nullable = false, length = 255)
    private String name;

    @Column(name = "住所", nullable = false, length = 255)
    private String location;

    @Column(name = "写真URL", columnDefinition = "TEXT")
    private String imageUrl;

    @Column(name = "概要", columnDefinition = "TEXT")
    private String description;

    @Column(name = "宿泊料金", nullable = false, precision = 10, scale = 2)
    private Double price;
}
