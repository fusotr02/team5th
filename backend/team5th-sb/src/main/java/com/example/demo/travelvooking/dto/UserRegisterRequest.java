package com.example.demo.travelvooking.dto;

public class UserRegisterRequest {
<<<<<<< HEAD
    private Long id;
=======
>>>>>>> d291d0c (エラー対処)
    private String name;
    private String email;
    private String password;

<<<<<<< HEAD
    // コンストラクタ
    public UserRegisterRequest(Long id, String name, String email) {
        this.id = id;
=======
    public UserRegisterRequest() {}

    public UserRegisterRequest(String name, String email, String password) {
>>>>>>> d291d0c (エラー対処)
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
