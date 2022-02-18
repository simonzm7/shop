package com.ceiba.config.filters;

import com.ceiba.infrastructure.error.ErrorHandler.Error;
import com.ceiba.users.implementations.jwt.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;


@RequiredArgsConstructor
public class AuthorizationFilter extends OncePerRequestFilter {

    private static final String LOGIN_PATH = "/login";
    private static final String SIGNUP_PATH = "/users";
    private static final String CONTENT_TYPE = "application/json";
    private final JwtUtil jwtUtil;

    private void throwException(HttpServletResponse response, Exception e) throws  IOException{
        response.setContentType(CONTENT_TYPE);
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        Error error = new Error(
                e.getClass().getSimpleName(),
                e.getMessage(),
                new Date()
        );
        new ObjectMapper().writeValue(response.getOutputStream(), error);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
       if (
               !request.getServletPath().equals(LOGIN_PATH) &&
                       !request.getServletPath().equals(SIGNUP_PATH)){
            String authHeader = request.getHeader("Authorization");
            if(authHeader != null && !authHeader.isEmpty() && authHeader.startsWith("Bearer ")) {
                String token = authHeader.substring("Bearer ".length());
                try{
                    String username = this.jwtUtil.getUsername(token);
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }catch (Exception e){
                    this.throwException(response, e);
                    return;
                }
            }
       }
        filterChain.doFilter(request, response);
    }
}
