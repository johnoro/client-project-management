package com.johnoro.cpm.config.security.jwt;

import com.johnoro.cpm.model.FakeUser;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class JwtProvider {
    private SecretKey key;
    private final JwtConfig jwtConfig;

    @Autowired
    public JwtProvider(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    @PostConstruct
    public void init() {
        key = Keys.hmacShaKeyFor(
            jwtConfig
                .getSecretKey()
                .getBytes(StandardCharsets.UTF_8)
        );
    }

    public String generateToken(Authentication auth) {
        User principal = (User) auth.getPrincipal();
        return generateToken(principal.getUsername());
    }

    public String generateToken(FakeUser user) {
        return generateToken(user.getUsername());
    }

    private String generateToken (String username) {
        JwtBuilder jwtBuilder = Jwts.builder()
            .setSubject(username)
            .signWith(key);
        return jwtBuilder.compact();
    }
}
