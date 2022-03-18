package uz.jl.lunch_order_rest.service.user;

import org.springframework.security.core.userdetails.UserDetailsService;
import uz.jl.lunch_order_rest.dto.user.UserCreateDto;
import uz.jl.lunch_order_rest.dto.user.UserDetailDto;
import uz.jl.lunch_order_rest.dto.user.UserGetDto;
import uz.jl.lunch_order_rest.dto.user.UserUpdateDto;
import uz.jl.lunch_order_rest.entity.user.UserEntity;
import uz.jl.lunch_order_rest.service.GenericCRUDService;
import uz.jl.lunch_order_rest.service.GenericService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface UserService extends GenericCRUDService<UserCreateDto, UserUpdateDto, UserGetDto, Long>, GenericService<UserGetDto, UserDetailDto, Long>, UserDetailsService {
    UserEntity getByUsername(String username);

    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
