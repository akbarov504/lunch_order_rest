package uz.jl.lunch_order_rest.mapper.token;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.jl.lunch_order_rest.dto.token.TokenCreateDto;
import uz.jl.lunch_order_rest.dto.token.TokenGetDto;
import uz.jl.lunch_order_rest.dto.token.TokenUpdateDto;
import uz.jl.lunch_order_rest.entity.token.TokenEntity;
import uz.jl.lunch_order_rest.mapper.GenericMapper;

@Component
@Mapper(componentModel = "spring")
public interface TokenMapper extends GenericMapper<TokenCreateDto, TokenUpdateDto, TokenGetDto, TokenEntity> {
}
