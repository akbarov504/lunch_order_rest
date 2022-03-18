package uz.jl.lunch_order_rest.entity.meal;

import lombok.*;
import uz.jl.lunch_order_rest.entity.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "meal", schema = "project")
public class MealEntity extends Auditable {
    @Column(name = "name", nullable = false, length = 120)
    private String name;

    @Column(name = "code", nullable = false, unique = true, updatable = false, length = 120)
    private UUID code;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "type", nullable = false, length = 50)
    private String type;
}
