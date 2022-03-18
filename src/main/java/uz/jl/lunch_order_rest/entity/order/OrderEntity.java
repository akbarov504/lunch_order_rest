package uz.jl.lunch_order_rest.entity.order;

import lombok.*;
import uz.jl.lunch_order_rest.entity.Auditable;
import uz.jl.lunch_order_rest.entity.meal.MealEntity;
import uz.jl.lunch_order_rest.entity.user.UserEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders", schema = "project")
public class OrderEntity extends Auditable {
    @Column(name = "date", updatable = false, columnDefinition = "TIMESTAMP default NOW()")
    private LocalDateTime date;

    private Boolean receive;

    @Column(name = "to_take")
    private Boolean toTake;

    @ManyToOne(targetEntity = UserEntity.class)
    private UserEntity user;

    @ManyToOne(targetEntity = MealEntity.class)
    private MealEntity meal;
}
