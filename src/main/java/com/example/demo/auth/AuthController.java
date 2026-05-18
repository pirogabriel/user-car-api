package com.example.demo.auth;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final JwtService jwtService;
    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(JwtService jwtService, AppUserRepository appUserRepository, PasswordEncoder passwordEncoder){
        this.jwtService = jwtService;
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Operation(summary = "Login")
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest request){
        AppUser user = appUserRepository.findByUsername(request.getUsername()).orElseThrow(() -> new IllegalArgumentException("Invalid Credentials"));

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new IllegalArgumentException("Invalid Credentials");
        }
        String accessToken = jwtService.generateToken(user.getUsername(), user.getRole());

        String refreshToken = jwtService.generateRefreshToken(user.getUsername());

        return Map.of("accessToken", accessToken, "refreshToken", refreshToken);
    }

    @Operation(summary = "Refresh token")
    @PostMapping("/refresh")
    public Map<String, String> refreshToken(@RequestBody Map<String, String> body){
        String refreshToken = body.get("refreshToken");

        if(!jwtService.isTokenValid(refreshToken)){
            throw new IllegalArgumentException("Invalid refresh token");
        }

        String username = jwtService.extractUsername(refreshToken);

        AppUser user = appUserRepository.findByUsername(username).orElseThrow();

        String newAccessToken = jwtService.generateToken(user.getUsername(), user.getRole());

        return Map.of("accessToken", newAccessToken);
    }
}