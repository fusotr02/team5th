package com.example.demo.travelvooking.service;

import java.util.List;

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
List<String> list;
    // コンストラクタで依存関係を注入
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // 🔑 ログイン処理
    public UserResponseDTO login(LoginRequest request) {
        // メールアドレスでユーザーを検索（存在しなければ例外）
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("ユーザーが見つかりません"));

        // パスワードの照合（平文 vs ハッシュ）
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("パスワードが正しくありません");
        }

        // ユーザー情報をレスポンスDTOで返す（パスワード除外）
        return new UserResponseDTO(user.getId(), user.getName(), user.getEmail());
    }

    // 📝 登録処理
    public UserResponseDTO register(UserRegisterRequest request) {
        // メールアドレスが既に使われていないか確認
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("このメールアドレスは既に登録されています");
        }

        // パスワードをハッシュ化
        String hashedPassword = passwordEncoder.encode(request.getPassword());

        // 新しいユーザーを作成して保存
        User newUser = new User(request.getName(), request.getEmail(), hashedPassword);
        User savedUser = userRepository.save(newUser);

        // レスポンスDTOとして返却
        return new UserResponseDTO(savedUser.getId(), savedUser.getName(), savedUser.getEmail());
    }
}
