package uz.jl.lunch_order_rest.entity.menu;

import lombok.*;
import uz.jl.lunch_order_rest.entity.Auditable;
import uz.jl.lunch_order_rest.entity.meal.MealEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "menu", schema = "project")
public class MenuEntity extends Auditable {
    @Column(name = "date", columnDefinition = "DATE default NOW()")
    private LocalDate date;

    @ManyToMany(targetEntity = MealEntity.class, fetch = FetchType.EAGER)
    private List<MealEntity> meals;
}
