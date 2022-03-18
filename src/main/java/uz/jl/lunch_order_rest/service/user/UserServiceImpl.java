package uz.jl.lunch_order_rest.service.user;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;
import uz.jl.lunch_order_rest.configuration.encription.PasswordEncoderConfiguration;
import uz.jl.lunch_order_rest.configuration.security.util.JwtUtil;
import uz.jl.lunch_order_rest.dto.token.TokenCreateDto;
import uz.jl.lunch_order_rest.dto.token.TokenGetDto;
import uz.jl.lunch_order_rest.dto.user.*;
import uz.jl.lunch_order_rest.entity.user.SessionUser;
import uz.jl.lunch_order_rest.entity.user.UserEntity;
import uz.jl.lunch_order_rest.enums.token.TokenEnum;
import uz.jl.lunch_order_rest.exception.custom_exception.NotFoundException;
import uz.jl.lunch_order_rest.mapper.user.UserMapper;
import uz.jl.lunch_order_rest.repository.user.UserRepository;
import uz.jl.lunch_order_rest.service.AbstractService;
import uz.jl.lunch_order_rest.service.token.TokenServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class UserServiceImpl extends AbstractService<UserMapper, UserRepository> implements UserService {
    private final TokenServiceImpl tokenService;

    public UserServiceImpl(UserMapper mapper, UserRepository repository, TokenServiceImpl tokenService) {
        super(mapper, repository);
        this.tokenService = tokenService;
    }

    @Override
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try {
                String refresh_token = authorizationHeader.substring("Bearer ".length());
                JWTVerifier verifier = JWT.require(JwtUtil.getAlgorithm()).build();
                DecodedJWT decoded = verifier.verify(refresh_token);
                String code = decoded.getSubject();
                UserEntity user = getByCode(code);
                Date date = JwtUtil.getExpiry();

                String accessToken = JWT.create()
                        .withSubject(user.getCode().toString())
                        .withExpiresAt(date)
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("role", user.getPosition())
                        .sign(JwtUtil.getAlgorithm());

                TokenCreateDto dto = new TokenCreateDto(user.getId(), accessToken, TokenEnum.ACCESS_TOKEN.name(), date.toLocalDate(), -1L);
                tokenService.create(dto);

                TokenGetDto access = new TokenGetDto(accessToken, TokenEnum.ACCESS_TOKEN.name());
                TokenGetDto refresh = new TokenGetDto(refresh_token, TokenEnum.REFRESH_TOKEN.name());
                List<TokenGetDto> tokens = new ArrayList<>();
                tokens.add(access);
                tokens.add(refresh);

                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
            } catch (Exception e) {
                response.setHeader("error", e.getMessage());
                response.setStatus(HttpStatus.FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                error.put("error_message", e.getMessage());
                response.setContentType(MimeTypeUtils.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }
        } else {
            throw new RuntimeException("Refresh token is missing");
        }
    }

    @Override
    public UserEntity getByUsername(String username) {
        return repository.findByUsername(username);
    }

    public UserEntity getByCode(String code) {
        return repository.findByCode(UUID.fromString(code));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity entity = repository.findByUsername(username);
        if (Objects.isNull(entity) || Objects.isNull(entity.getDepartmentId())) {
            throw new NotFoundException("User not found");
        }
        return new SessionUser(entity);
    }

    @Override
    public void create(UserCreateDto dto) {
        PasswordEncoderConfiguration configuration = new PasswordEncoderConfiguration();
        UserEntity entity = mapper.fromCreateDto(dto);
        entity.setCode(UUID.randomUUID());
        entity.setChatId(dto.getChatId());
        entity.setPassword(configuration.passwordEncoder().encode(dto.getPassword()));
        entity.setCreatedAt(LocalDateTime.now());
        repository.save(entity);
    }

    @Override
    public void update(UserUpdateDto dto) {
        repository.updateById(dto.getId(), dto.getUsername(), dto.getFullName(), dto.getPhone(), dto.getPosition(), dto.getDepartmentId());
    }

    @Override
    public void delete(Long key) {
        repository.deleteById(key);
    }

    @Override
    public UserGetDto get(Long key) {
        return mapper.toGetDto(repository.findById(key).orElseThrow(() -> {
            throw new NotFoundException("User not found");
        }));
    }

    @Override
    public UserDetailDto detail(Long key) {
        return null;
    }

    @Override
    public List<UserGetDto> list() {
        return mapper.toGetListDto(repository.findAll());
    }

    @Override
    public Long totalCount() {
        return repository.count();
    }

    public void acceptDepartment(UserAcceptDepartmentDto dto) {
        repository.updateDepartmentIdById(dto.getDepartmentId(), dto.getUserId());
    }

    public UserGetDto getByPhoneNumber(String phone) {
        return mapper.toGetDto(repository.findByPhone(phone));
    }

    public UserGetDto getByChatId(Integer chatId) {
        UserEntity entity = repository.findByChatId(chatId);
        UserGetDto userGetDto = mapper.toGetDto(entity);
        userGetDto.setDepartmentId(entity.getDepartmentId());
        return userGetDto;
    }
}
