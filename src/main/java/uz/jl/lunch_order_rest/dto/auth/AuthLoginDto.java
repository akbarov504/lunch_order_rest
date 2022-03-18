package uz.jl.lunch_order_rest.dto.auth;

import lombok.*;
import uz.jl.lunch_order_rest.dto.BaseDto;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AuthLoginDto implements BaseDto {
    private String username;
    private String password;
}
