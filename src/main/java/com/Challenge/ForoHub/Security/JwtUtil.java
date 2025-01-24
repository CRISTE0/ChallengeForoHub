package com.Challenge.ForoHub.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    private static final String SECRET_KEY = "348cisChimbA348cisChimbA348cisChimbA348cisChimbA348cisChimbA348cisChimbA348cisChimbA348cisChimbA348cisChimbA348cisChimbA348cisChimbA348cisChimbA348cisChimbA348cisChimbA348cisChimbA348cisChimbA348cisChimbA348cisChimbA348cisChimbA348cisChimbA348cisChimbA348cisChimbA348cisChimbA348cisChimbA348cisChimbA348cisChimbA348cisChimbA348cisChimbA348cisChimbA348cisChimbA348cisChimbA"; // Cambia esto a una clave segura

    // Generar Token
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 horas
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    // Validar Token
    public boolean validateToken(String token, String username) {
        String tokenUsername = extractUsername(token);
        return tokenUsername.equals(username) && !isTokenExpired(token);
    }

    // Obtener Usuario del Token
    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    // Validar si el Token está Expirado
    public boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }

    // Extraer Claims
    private Claims extractClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }
}
