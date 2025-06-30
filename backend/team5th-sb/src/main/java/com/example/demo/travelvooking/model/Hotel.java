package com.example.demo.travelvooking.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ホテルID")
    private Long id;

    @Column(name = "ホテル名", nullable = false, length = 255)
    private String name;

    @Column(name = "住所", nullable = false, length = 255)
    private String location;

    @Column(name = "都道府県", nullable = false, length = 100)
    private String region;  // ← 追加：検索用の都道府県フィールド

    @Column(name = "写真URL", columnDefinition = "TEXT")
    private String imageUrl;

    @Column(name = "概要", columnDefinition = "TEXT")
    private String description;


    @Column(name = "宿泊料金", nullable = false)

    @Column(name = "宿泊料金", nullable = false, precision = 10, scale = 2)

    private Integer price;
}

