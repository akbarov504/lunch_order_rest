package uz.jl.lunch_order_rest.service.token;

import uz.jl.lunch_order_rest.dto.token.TokenCreateDto;
import uz.jl.lunch_order_rest.dto.token.TokenDetailDto;
import uz.jl.lunch_order_rest.dto.token.TokenGetDto;
import uz.jl.lunch_order_rest.dto.token.TokenUpdateDto;
import uz.jl.lunch_order_rest.service.GenericCRUDService;
import uz.jl.lunch_order_rest.service.GenericService;

public interface TokenService extends GenericCRUDService<TokenCreateDto, TokenUpdateDto, TokenGetDto, Long>, GenericService<TokenGetDto, TokenDetailDto, Long> {
}
