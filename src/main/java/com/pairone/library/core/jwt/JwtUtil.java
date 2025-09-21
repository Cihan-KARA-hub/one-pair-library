package com.pairone.library.core.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;

@Service
public class JwtUtil {
    private final String SECRET_KEY = "2e21b7d0567485d4a828b1fc08788eea128d8f24917f04ab7e4e1e2baf68d2286b935cec1572bb3b0d108ec8c4ad3287cdeeacdf30d7dfdc34c16b24cb75fc8d";

    public String generateToken(String username) {
        Date expirationDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60);
        SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

        HashMap<String, Object> claims = new HashMap<String, Object>();
        claims.put("username", username);
        claims.put("admin", true);

        String jwt = Jwts
                .builder()
                .claims(claims)
                .subject(username)
                .signWith(key)
                .expiration(expirationDate)
                .issuedAt(new Date(System.currentTimeMillis()))
                .compact();
        return jwt;
    }

    public Boolean validateToken(String token) {
        Claims claims = extractAllClaims(token);
        return claims.getExpiration().after((new Date()));
    }

    public String extractUsername(String token) {
        Claims claims = extractAllClaims(token);
        return claims.getSubject();
    }

    private Claims extractAllClaims(String token) {
        if (token == null || token.trim().isEmpty()) {
            throw new IllegalArgumentException("JWT token cannot be null or empty");
        }

        SecretKey secretKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
