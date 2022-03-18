package uz.jl.lunch_order_rest.entity.complaint;

import lombok.*;
import uz.jl.lunch_order_rest.entity.Auditable;
import uz.jl.lunch_order_rest.entity.user.UserEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "complaint", schema = "project")
public class ComplaintEntity extends Auditable {
    @Column(name = "message", nullable = false, updatable = false)
    private String message;

    private Long userId;
}
