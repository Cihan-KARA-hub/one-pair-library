package com.pairone.library.service;

import com.pairone.library.core.jwt.JwtUtil;
import com.pairone.library.dto.auth.request.LoginRequest;
import com.pairone.library.dto.auth.request.RegisterRequest;
import com.pairone.library.dto.auth.response.LoginResponse;
import com.pairone.library.dto.auth.response.RegisteredResponse;
import com.pairone.library.entity.User;
import com.pairone.library.repository.UserRepository;
import com.pairone.library.rules.AuthBusinessRule;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthBusinessRule authBusinessRule;
    private final JwtUtil jwtUtil;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthBusinessRule authBusinessRule, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authBusinessRule = authBusinessRule;

        this.jwtUtil = jwtUtil;
    }

    public RegisteredResponse register(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);
        RegisteredResponse response = new RegisteredResponse();
        response.setUsername(user.getUsername());
        return response;
    }

    public LoginResponse login(LoginRequest request) {
        User user = authBusinessRule.findByUsername(request.getUsername());
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("wrong username or password");
        }
        LoginResponse response = new LoginResponse();
        response.setToken(jwtUtil.generateToken(request.getUsername()));
        return response;
    }

    public Boolean validateToken(String token) {
        return jwtUtil.validateToken(token);
    }
}
