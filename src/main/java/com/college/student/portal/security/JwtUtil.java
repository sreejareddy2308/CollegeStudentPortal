package com.college.student.portal.security;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
@Component
public class JwtUtil {

	// Secret key for signing the token
    private final String SECRET_KEY = "wertyuiopsad345678mnnejru4569o5i7uinmfd4578cwe5678ikmnbgt678olmnbgfinrhjermdhfrtmjtrgjei574";

    // Token validity duration (60 minutes)
    private final long TOKEN_EXPIRY_DURATION = 60 * 60 * 1000;

    // Convert the secret string into a SecretKey (HMAC-SHA)
    private SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

    // Create a JWT token for a given user name
    public String createToken(String username) {
        String token = Jwts.parser()
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRY_DURATION))
                .signWith(getSecretKey())
                .compact();

        System.out.println("Generated Token: " + token);
        return token;
    }

    // Extract user name from the token
    public String getUsernameFromToken(String token) {
        return  Jwts.parser()
                .signingKey(getSecretKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // Check if the token has expired
    public boolean isTokenExpired(String token) {
        Date expiryTime = Jwts.parserBuilder()
                .setSigningKey(getSecretKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
        System.out.println("Token Expiry Time: " + expiryTime);
        return expiryTime.before(new Date()); 
    }

    // Validate the token against user name
    public boolean isValidToken(String token, String username) {
        String usernameFromToken = getUsernameFromToken(token);
        System.out.println("Username from token: " + usernameFromToken);
        return usernameFromToken.equalsIgnoreCase(username) && !isTokenExpired(token);
        
       
    }
}
