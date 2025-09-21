package com.pairone.library.controller;

import com.pairone.library.dto.auth.request.LoginRequest;
import com.pairone.library.dto.auth.request.RegisterRequest;
import com.pairone.library.dto.auth.response.RegisteredResponse;
import com.pairone.library.dto.auth.response.LoginResponse;
import com.pairone.library.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/auth")
@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("register")
    @ResponseStatus(HttpStatus.CREATED)
    public RegisteredResponse register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

    @GetMapping("verify-token")
    public Boolean verifyToken(@RequestParam(value = "token",required = false) String token) {
        return authService.validateToken(token);
    }
}