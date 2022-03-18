package uz.jl.lunch_order_rest.dto.meal;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import uz.jl.lunch_order_rest.dto.BaseDto;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MealCreateDto implements BaseDto {
    private String name;

    private String image;

    private String type;

    @SerializedName(value = "created_by")
    private Long createdBy;
}
