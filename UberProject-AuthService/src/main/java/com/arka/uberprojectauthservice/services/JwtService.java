package com.arka.uberprojectauthservice.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService implements CommandLineRunner {

    @Value("${jwt.expiry}")
    private int expiry;

    @Value("${jwt.secret}")
    private String SECRET;
    private String email;


    // this methiod is create a bernad new jwt tocken based on playload
    public String createTocken(Map<String, Object> playload,String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiry*1000L);
        SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
        return Jwts.builder()
                .setClaims(playload)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(expiryDate)
                .setSubject(email)
                .signWith(getSignInKey())
                .compact();
    }
    public String createTocken(String email) {
        return createTocken(new HashMap<>(), email);
    }


    public Claims extractAllPayload(String tocken){
       return Jwts.parser()
               .setSigningKey(getSignInKey())
               .build()
               .parseClaimsJws(tocken)
               .getBody();
    }

    public <T> T extractClaims(String tocken, Function<Claims,T> claimsResolver){
        final Claims claims=extractAllPayload(tocken);
        return claimsResolver.apply(claims);
    }

    public Date extractExpiration(String token) {
        return extractClaims(token, Claims::getExpiration);
    }
    public String extractEmail(String token) {
        String email = extractClaims(token, Claims::getSubject);
        return email;
    }


    public boolean isToken(String token) {
        return extractExpiration(token).before(new Date());
    }


    public Key getSignInKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
    }

    public Boolean validateToken(String token,String email) {
        final String userEmailFectcedFFromTocken = extractEmail(token);
        return (userEmailFectcedFFromTocken.equals(email)) && !isToken(token);
    }

    @Override
    public void run(String... args) throws Exception {
        Map<String,Object> mp = new HashMap<>();
        mp.put("email","abc@gmail.com");
        mp.put("Phone number","9876567896");

        String result = createTocken(mp,"arka");
//        System.out.println(result);
//        System.out.println(extractEmail(result));
    }
}
