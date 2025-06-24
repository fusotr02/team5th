package com.example.demo.travelvooking.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.travelvooking.dto.LoginRequest;
import com.example.demo.travelvooking.dto.UserRegisterRequest;
import com.example.demo.travelvooking.dto.UserResponseDTO;
import com.example.demo.travelvooking.model.User;
import com.example.demo.travelvooking.repository.UserRepository;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponseDTO login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("ユーザーが見つかりません"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("パスワードが正しくありません");
        }

        return new UserResponseDTO(user.getId(), user.getName(), user.getEmail());
    }

    public UserResponseDTO register(UserRegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("このメールアドレスは既に登録されています");
        }

        String hashedPassword = passwordEncoder.encode(request.getPassword());
        User newUser = new User(request.getName(), request.getEmail(), hashedPassword);
        User savedUser = userRepository.save(newUser);

        return new UserResponseDTO(savedUser.getId(), savedUser.getName(), savedUser.getEmail());
    }
}
