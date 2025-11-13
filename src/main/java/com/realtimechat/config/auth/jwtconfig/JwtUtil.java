package com.realtimechat.config.auth.jwtconfig;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
@Slf4j
public class JwtUtil {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration-ms}")
    private int expiryMilliseconds;

    private SecretKey key;

    @PostConstruct
    public void init(){
        this.key= Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));
    }

    private String generateToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiryMilliseconds))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    private String getUsernameFromToken(String token){
        return Jwts.parserBuilder()
                .setSigningKey(key).build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateJwtToken(String token){
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        }catch (SecurityException e){
            log.error("Invalid Jwt signature :{}",e.getMessage());
        }catch (MalformedJwtException e){
            log.error("Invalid Jwt token :{}",e.getMessage());
        }catch (ExpiredJwtException e){
            log.error("Expired Jwt token :{}",e.getMessage());
        }catch (UnsupportedJwtException e){
            log.error("Unsupported Jwt token :{}",e.getMessage());
        }catch (IllegalArgumentException e){
            log.error("Jwt claims signature is empty :{}",e.getMessage());
        }
        return false;
    }
}
