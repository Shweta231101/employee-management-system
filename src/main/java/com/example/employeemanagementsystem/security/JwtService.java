package com.example.employeemanagementsystem.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.function.Function;


@Service
public class JwtService {


    private final String SECRET =
            "mysecretkeymysecretkeymysecretkey123456";


    private SecretKey getKey(){

        return Keys.hmacShaKeyFor(
                SECRET.getBytes(StandardCharsets.UTF_8)
        );
    }



    public String generateToken(String username){


        return Jwts.builder()

                .subject(username)

                .issuedAt(new Date())

                .expiration(
                        new Date(
                                System.currentTimeMillis()
                                        + 1000 * 60 * 60 * 10
                        )
                )

                .signWith(getKey())

                .compact();

    }




    public String extractUsername(String token){

        return extractClaim(
                token,
                Claims::getSubject
        );
    }




    public <T> T extractClaim(
            String token,
            Function<Claims,T> resolver
    ){

        Claims claims =
                Jwts.parser()

                        .verifyWith(getKey())

                        .build()

                        .parseSignedClaims(token)

                        .getPayload();


        return resolver.apply(claims);

    }




    public boolean validateToken(
            String token,
            String username
    ){

        return username.equals(extractUsername(token));

    }

}