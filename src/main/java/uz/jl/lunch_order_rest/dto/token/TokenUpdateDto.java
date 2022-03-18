package uz.jl.lunch_order_rest.dto.token;

import lombok.*;
import uz.jl.lunch_order_rest.dto.GenericDto;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TokenUpdateDto extends GenericDto {
    private String token;
}
