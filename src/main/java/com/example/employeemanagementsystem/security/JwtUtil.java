package com.example.employeemanagementsystem.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;


public class JwtUtil {


    private static final String SECRET_KEY =
            "mysecretkeymysecretkeymysecretkey123456";


    private static final long EXPIRATION_TIME =
            1000 * 60 * 60 * 10; // 10 hours



    private static SecretKey getSigningKey() {

        return Keys.hmacShaKeyFor(
                SECRET_KEY.getBytes(StandardCharsets.UTF_8)
        );

    }



    // Generate JWT Token
    public static String generateToken(String username) {


        return Jwts.builder()

                .subject(username)

                .issuedAt(new Date())

                .expiration(
                        new Date(
                                System.currentTimeMillis()
                                        + EXPIRATION_TIME
                        )
                )

                .signWith(getSigningKey())

                .compact();

    }



    // Extract all claims from token
    public static Claims extractClaims(String token) {


        return Jwts.parser()

                .verifyWith(getSigningKey())

                .build()

                .parseSignedClaims(token)

                .getPayload();

    }



    // Extract username from token
    public static String extractUsername(String token) {


        return extractClaims(token)
                .getSubject();

    }



    // Check token validity
    public static boolean isTokenValid(
            String token,
            String username
    ) {


        String extractedUsername =
                extractUsername(token);


        return extractedUsername.equals(username)
                && !isTokenExpired(token);

    }



    // Check token expiration
    private static boolean isTokenExpired(String token) {


        Date expiration =
                extractClaims(token)
                        .getExpiration();


        return expiration.before(new Date());

    }

}