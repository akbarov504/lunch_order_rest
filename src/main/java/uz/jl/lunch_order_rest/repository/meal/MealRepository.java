package uz.jl.lunch_order_rest.repository.meal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.jl.lunch_order_rest.entity.meal.MealEntity;
import uz.jl.lunch_order_rest.repository.BaseRepository;

import javax.transaction.Transactional;

public interface MealRepository extends JpaRepository<MealEntity, Long>, BaseRepository {
    @Transactional
    @Modifying
    @Query("update MealEntity set name = :name, type = :type, image = :image where id = :id")
    void updateById(@Param(value = "id") Long id, @Param(value = "name") String name, @Param(value = "type") String type, @Param(value = "image") String image);

    MealEntity findByName(String name);
}
