package com.ceiba.config.filters;

import com.ceiba.domain.exception.IncorrectCredentials;
import com.ceiba.domain.exception.RequiredException;
import com.ceiba.infrastructure.error.ErrorHandler.Error;
import com.ceiba.users.command.LoginUserCommand;
import com.ceiba.users.command.handler.LoginUserHandler;
import com.ceiba.users.implementations.jwt.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@RequiredArgsConstructor
@Slf4j
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final LoginUserHandler loginUserHandler;
    private final JwtUtil jwtUtil;
    private static final String CONTENT_TYPE = "application/json";


    private void throwException(HttpServletResponse response, Exception e) throws IOException{
        response.setContentType(CONTENT_TYPE);
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        Error error = new Error(
                e.getClass().getSimpleName(),
                e.getMessage(),
                new Date()
        );
        new ObjectMapper().writeValue(response.getOutputStream(), error);
    }


    @SneakyThrows
    @Override
        public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        final String email = request.getParameter("email");
        final String password = request.getParameter("password");
        LoginUserCommand loginUserCommand = new LoginUserCommand(email, password, authenticationManager);
        try{
            return this.loginUserHandler.execute(loginUserCommand);
        }catch (Exception e){
            this.throwException(response, e);
        }
        return null;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        User user = (User)authResult.getPrincipal();
        String token = this.jwtUtil.createJwtToken(user.getUsername(), request.getRequestURI());
        response.setContentType(CONTENT_TYPE);
        new ObjectMapper().writeValue(response.getOutputStream(), new JwtResponse(token));
    }
}
