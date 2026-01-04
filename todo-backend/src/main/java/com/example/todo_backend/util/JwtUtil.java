package com.example.todo_backend.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {

    // 本来は application.yml などに置く
    private static final String SECRET_KEY = "my-secret-key-my-secret-key-my-secret-key";
    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1時間
    private static final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    //JWT発行
    public static String generateToken(Long userId) {
        return Jwts.builder()
                .setSubject(userId.toString())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    //JWT検証 & userId取得
    public static Long validateAndGetUserId(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return Long.valueOf(claims.getSubject());
    }
}
