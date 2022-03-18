package uz.jl.lunch_order_rest.entity.department;

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
@Table(name = "department", schema = "project")
public class DepartmentEntity extends Auditable {
    @Column(name = "name", nullable = false, length = 120)
    private String name;

    @Column(name = "code", nullable = false, updatable = false, unique = true, length = 120)
    private UUID code;

    @Column(name = "user_id")
    private Long userId;
}
