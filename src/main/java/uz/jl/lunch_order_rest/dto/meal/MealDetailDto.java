package uz.jl.lunch_order_rest.dto.meal;

import lombok.*;
import uz.jl.lunch_order_rest.dto.GenericDto;

import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MealDetailDto extends GenericDto {
    private String name;

    private UUID code;

    private String image;

    private String type;
}
