package uz.jl.lunch_order_rest.configuration.security.filter;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import uz.jl.lunch_order_rest.configuration.security.util.JwtUtil;
import uz.jl.lunch_order_rest.dto.auth.AuthLoginDto;
import uz.jl.lunch_order_rest.dto.token.TokenCreateDto;
import uz.jl.lunch_order_rest.dto.token.TokenGetDto;
import uz.jl.lunch_order_rest.entity.user.SessionUser;
import uz.jl.lunch_order_rest.enums.token.TokenEnum;
import uz.jl.lunch_order_rest.service.token.TokenServiceImpl;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final TokenServiceImpl tokenService;
    private final AuthenticationManager authenticationManager;

    public CustomAuthenticationFilter(TokenServiceImpl tokenService, AuthenticationManager authenticationManager) {
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
        super.setFilterProcessesUrl("/api/auth/login/");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        try {
            AuthLoginDto dto = new ObjectMapper().readValue(request.getReader(), AuthLoginDto.class);
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword());
            return authenticationManager.authenticate(token);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        SessionUser user = (SessionUser) authentication.getPrincipal();
        Date accessDate = JwtUtil.getExpiry();
        Date refreshDate = JwtUtil.getExpiryForRefreshToken();

        String accessToken = JWT.create()
                .withSubject(user.getCode().toString())
                .withExpiresAt(accessDate)
                .withIssuer(request.getRequestURL().toString())
                .withClaim("role", user.getPosition())
                .sign(JwtUtil.getAlgorithm());

        String refreshToken = JWT.create()
                .withSubject(user.getCode().toString())
                .withExpiresAt(refreshDate)
                .withIssuer(request.getRequestURL().toString())
                .sign(JwtUtil.getAlgorithm());

        TokenCreateDto dto1 = new TokenCreateDto(user.getId(), accessToken, TokenEnum.ACCESS_TOKEN.name(), accessDate.toLocalDate(), -1L);
        TokenCreateDto dto2 = new TokenCreateDto(user.getId(), refreshToken, TokenEnum.REFRESH_TOKEN.name(), refreshDate.toLocalDate(), -1L);

        tokenService.create(dto1);
        tokenService.create(dto2);

        TokenGetDto access = new TokenGetDto(accessToken, TokenEnum.ACCESS_TOKEN.name());
        TokenGetDto refresh = new TokenGetDto(refreshToken, TokenEnum.REFRESH_TOKEN.name());
        List<TokenGetDto> tokens = new ArrayList<>();
        tokens.add(access);
        tokens.add(refresh);

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getOutputStream(), tokens);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        super.unsuccessfulAuthentication(request, response, failed);
    }
}
