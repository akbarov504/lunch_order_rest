package uz.jl.lunch_order_rest.repository.menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.jl.lunch_order_rest.entity.menu.MenuEntity;
import uz.jl.lunch_order_rest.repository.BaseRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

public interface MenuRepository extends JpaRepository<MenuEntity, Long>, BaseRepository {
    @Query("from MenuEntity where date = :date")
    List<MenuEntity> findAllByDate(@Param(value = "date") LocalDate date);

    @Query("from MenuEntity where date between :to and :from")
    List<MenuEntity> findAllByToAndFrom(@Param(value = "to") LocalDate to, @Param(value = "from") LocalDate from);

    @Transactional
    @Modifying
    @Query("update MenuEntity set date = :date where id = :id")
    void updateById(@Param(value = "id") Long id, @Param(value = "date") LocalDate date);

    @Modifying
    @Query(value = "insert into menu_meals (menu_entity_id, meals_id) values (:id, :mealId);", nativeQuery = true)
    void addMealById(@Param(value = "id") Long id, @Param(value = "mealId") Long mealId);

    @Modifying
    @Query(value = "delete from menu_meals where menu_entity_id = :id and meals_id = :mealId;", nativeQuery = true)
    void deleteMealById(@Param(value = "id") Long id, @Param(value = "mealId") Long mealId);

    @Query("from MenuEntity where date = current_date or date = :yesterday")
    MenuEntity getToday(LocalDate yesterday);
}
