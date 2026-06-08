package com.example.Springboot.config;

public package com.example.Springboot.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    // 1. Generamos una clave secreta segura y robusta para firmar los tokens
    private final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS266);
    
    // El token expirará en 24 horas (en milisegundos)
    private final long EXPIRATION_TIME = 86400000; 

    // 2. Método para generar el Token JWT usando el email del usuario
    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SECRET_KEY)
                .compact();
    }

    // 3. Método para extraer el email (Subject) de un token existente
    public String extractEmail(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // 4. Método para comprobar si el token ha expirado
    public boolean isTokenExpired(String token) {
        Date expiration = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
        return expiration.before(new Date());
    }
} {
    
}
