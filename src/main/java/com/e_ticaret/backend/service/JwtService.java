package com.e_ticaret.backend.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    @Value("${security.jwt.secret}")
    private String SECRET_KEY;

    public String findByUsername(String jwt) {
        return exportToken(jwt, Claims::getSubject);
    }

    private <T> T exportToken(String jwt, Function<Claims, T> claimsTFunction) {
       final Claims claims = Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build().parseClaimsJws(jwt).getBody();
                
        return claimsTFunction.apply(claims);
    }

    private Key getKey() {
        byte[] key = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(key);
    }

    public boolean tokenControl(String jwt, UserDetails userDetails) {
        final String username = findByUsername(jwt);
        return (username.equals(userDetails.getUsername()) && !exportToken(jwt, Claims::getExpiration).before(new Date()));
    }

    public String generateToken(UserDetails user){
        return Jwts.builder()
                .setClaims(new HashMap<>())
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 10))
                .signWith(getKey())
                .compact();
    }
    
}
