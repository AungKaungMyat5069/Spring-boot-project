package com.example.todobackend.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Component
public class JwtTokenProvider {
    @Value("${jwt.key.secret}")
    private String jwtSecret;
    @Value("${jwt.key.expiration.hour}")
    private Long jwtExpiration;

    //token generate
    public String generateToken(Authentication authentication) {
        String username = authentication.getName();
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + jwtExpiration);

        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(keys())
                .compact();
        return token;
    }

    //key dead
    private Key keys() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public String getUsernameFromToken (String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(keys())
                .build()
//                .parseClaimsJwt() <- Dont wrong with this
                .parseClaimsJws(token)
                .getBody();
        String username = claims.getSubject();
        return username;
    }

    public boolean validateToken(String token) {
        Jwts.parser().setSigningKey(keys())
                .build()
                .parse(token);
        return true;
    }
}
