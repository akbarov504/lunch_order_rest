package uz.jl.lunch_order_rest.entity.user;

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
@Table(name = "user", schema = "auth")
public class UserEntity extends Auditable {
    @Column(name = "username", nullable = false, unique = true, length = 120)
    private String username;

    @Column(name = "code", nullable = false, unique = true, updatable = false, length = 120)
    private UUID code;

    @Column(name = "password", nullable = false, length = 120)
    private String password;

    @Column(name = "full_name", nullable = false, length = 120)
    private String fullName;

    @Column(name = "phone", nullable = false, unique = true, length = 13)
    private String phone;

    @Column(name = "language", nullable = false, length = 50)
    private String language;

    @Column(name = "position", nullable = false, length = 50)
    private String position;

    @Column(name = "chat_id")
    private Integer chatId;

    @Column(name = "department_id")
    private Long departmentId;
}
