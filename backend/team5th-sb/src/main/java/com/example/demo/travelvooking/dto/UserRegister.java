package com.example.demo.travelbooking.dto;

public class UserResponseDTO {
    private Long id;
    private String name;
    private String email;

    // コンストラクタ
    public UserResponseDTO(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // getterのみ（パスワードなどは含めない）
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
