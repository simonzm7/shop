package com.ceiba.users.implementations.jwt;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ceiba.infrastructure.exception.TechnicalException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import com.auth0.jwt.JWT;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class JwtUtil {



    public String createJwtToken(String email, String requestUrl){
        Algorithm algorithm = Algorithm.HMAC256("SECRET".getBytes(StandardCharsets.UTF_8));
        return JWT.create()
                .withSubject(email)
                .withExpiresAt(new Date(System.currentTimeMillis() + 10  * 60 * 1000))
                .withIssuer(requestUrl)
                .sign(algorithm);
    }

    private String verifyJwtToken(String token){
        Algorithm algorithm = Algorithm.HMAC256("SECRET".getBytes(StandardCharsets.UTF_8));
        JWTVerifier jwtVerifier = JWT.require(algorithm).build();
        try{
            DecodedJWT decodedJWT = jwtVerifier.verify(token);
            return decodedJWT.getSubject();
        }catch (Exception e){
            throw new TechnicalException("Invalid authorization token");
        }
    }

    public String getUsername(String token){
        return this.verifyJwtToken(token);
    }
}
