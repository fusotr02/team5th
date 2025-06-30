package com.example.demo.travelvooking.controller;

<<<<<<< HEAD
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

>>>>>>> 76b492f470a59431380550b26832dae7b81c0e92
import com.example.demo.travelvooking.dto.LoginRequest;
import com.example.demo.travelvooking.dto.UserRegisterRequest;
import com.example.demo.travelvooking.dto.UserResponseDTO;
import com.example.demo.travelvooking.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
<<<<<<< HEAD
@RequestMapping("/auth")  // Vue 側では `/api/auth` になる（proxy設定で）
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
=======
@RequestMapping("/auth")
@CrossOrigin
>>>>>>> 76b492f470a59431380550b26832dae7b81c0e92
public class AuthController {

    @Autowired
    private AuthService authService;

    /**
     * ログイン処理
     */
    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> login(@RequestBody LoginRequest request) {
        UserResponseDTO user = authService.login(request);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    /**
     * 新規登録処理
     */
    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody UserRegisterRequest request) {
        UserResponseDTO user = authService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    /**
     * ログアウト処理（必要に応じて）
     */
    @PostMapping("/logout")
    public ResponseEntity<Void> logout() {
        // セッションなどがある場合、無効化処理を書く
        return ResponseEntity.ok().build();
    }
}
