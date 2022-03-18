package uz.jl.lunch_order_rest.repository.token;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.jl.lunch_order_rest.entity.token.TokenEntity;
import uz.jl.lunch_order_rest.repository.BaseRepository;

public interface TokenRepository extends JpaRepository<TokenEntity, Long>, BaseRepository {
}
