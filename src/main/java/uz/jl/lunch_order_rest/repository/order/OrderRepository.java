package uz.jl.lunch_order_rest.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.jl.lunch_order_rest.entity.order.OrderEntity;
import uz.jl.lunch_order_rest.repository.BaseRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long>, BaseRepository {
    List<OrderEntity> findAllByUserId(Long userId);

    @Transactional
    @Modifying
    @Query("update OrderEntity set date = :date, receive = :receive, toTake = :toTake, user.id = :userId, meal.id = :mealId where id = :id")
    void updateById(@Param(value = "id") Long id, @Param(value = "date") LocalDateTime date, @Param(value = "receive") Boolean receive, @Param(value = "toTake") Boolean toTake, @Param(value = "userId") Long userId, @Param(value = "mealId") Long mealId);
}
