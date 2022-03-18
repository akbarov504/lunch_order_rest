package uz.jl.lunch_order_rest.mapper.user;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.jl.lunch_order_rest.dto.user.UserCreateDto;
import uz.jl.lunch_order_rest.dto.user.UserGetDto;
import uz.jl.lunch_order_rest.dto.user.UserUpdateDto;
import uz.jl.lunch_order_rest.entity.user.UserEntity;
import uz.jl.lunch_order_rest.mapper.GenericMapper;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper<UserCreateDto, UserUpdateDto, UserGetDto, UserEntity> {
}
