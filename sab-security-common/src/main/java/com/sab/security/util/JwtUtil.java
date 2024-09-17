package com.sab.security.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class JwtUtil {
    private static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);


    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(String username) {

        Map<String, Object> claims = new HashMap<>();
        return createToken(username, claims);
    }

    public String createToken(String username, Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)                          // Set custom claims (roles)
                .setSubject(username)                       // Set the username as the subject
                .setIssuedAt(new Date(System.currentTimeMillis()))  // Set the issue time
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // Set expiration (10 hours)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY) // Sign the token with the secret key using HS256
                .compact();
    }

    public Boolean validateToken(String token, String username) {
        final String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }

    public Collection<? extends GrantedAuthority> getAuthoritiesFromClaims(Claims claims) {
        // Assuming roles are stored in the claim with key "roles"
        List<String> roles = claims.get("roles", List.class);

        // Convert the roles to GrantedAuthority objects and return them
        return roles.stream()
                .map(SimpleGrantedAuthority::new) // Wrap each role in a SimpleGrantedAuthority
                .collect(Collectors.toList());
    }

}
