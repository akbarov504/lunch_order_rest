package uz.jl.lunch_order_rest.dto.meal;

import lombok.*;
import uz.jl.lunch_order_rest.dto.GenericDto;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MealUpdateDto extends GenericDto {
    private String name;

    private String image;

    private String type;
}
