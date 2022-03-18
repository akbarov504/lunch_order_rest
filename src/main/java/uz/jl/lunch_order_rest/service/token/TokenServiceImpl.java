package uz.jl.lunch_order_rest.service.token;

import org.springframework.stereotype.Service;
import uz.jl.lunch_order_rest.dto.token.TokenCreateDto;
import uz.jl.lunch_order_rest.dto.token.TokenDetailDto;
import uz.jl.lunch_order_rest.dto.token.TokenGetDto;
import uz.jl.lunch_order_rest.dto.token.TokenUpdateDto;
import uz.jl.lunch_order_rest.entity.token.TokenEntity;
import uz.jl.lunch_order_rest.exception.custom_exception.NotFoundException;
import uz.jl.lunch_order_rest.mapper.token.TokenMapper;
import uz.jl.lunch_order_rest.repository.token.TokenRepository;
import uz.jl.lunch_order_rest.service.AbstractService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TokenServiceImpl extends AbstractService<TokenMapper, TokenRepository> implements TokenService {
    public TokenServiceImpl(TokenMapper mapper, TokenRepository repository) {
        super(mapper, repository);
    }

    @Override
    public void create(TokenCreateDto dto) {
        TokenEntity entity = mapper.fromCreateDto(dto);
        entity.setCreatedAt(LocalDateTime.now());
        repository.save(entity);
    }

    @Override
    public void update(TokenUpdateDto dto) {

    }

    @Override
    public void delete(Long key) {
        repository.deleteById(key);
    }

    @Override
    public TokenGetDto get(Long key) {
        return mapper.toGetDto(repository.findById(key).orElseThrow(() -> {
            throw new NotFoundException("Token not found");
        }));
    }

    @Override
    public TokenDetailDto detail(Long key) {
        return null;
    }

    @Override
    public List<TokenGetDto> list() {
        return mapper.toGetListDto(repository.findAll());
    }

    @Override
    public Long totalCount() {
        return repository.count();
    }
}
