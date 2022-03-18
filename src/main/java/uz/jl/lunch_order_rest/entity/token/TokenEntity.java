package uz.jl.lunch_order_rest.entity.token;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import uz.jl.lunch_order_rest.entity.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "token", schema = "auth")
public class TokenEntity extends Auditable {
    @Column(nullable = false, updatable = false)
    @SerializedName(value = "user_id")
    private Long userId;

    @Column(nullable = false, updatable = false, unique = true)
    private String token;

    @Column(nullable = false, updatable = false)
    private String type;

    @Column(nullable = false, updatable = false)
    private LocalDate duration;
}
