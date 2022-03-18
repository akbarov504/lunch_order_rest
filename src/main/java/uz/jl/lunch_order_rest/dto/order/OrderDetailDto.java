package uz.jl.lunch_order_rest.dto.order;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import uz.jl.lunch_order_rest.dto.GenericDto;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailDto extends GenericDto {
    private LocalDateTime date;

    private Boolean receive;

    @SerializedName(value = "to_take")
    private Boolean toTake;

    @SerializedName(value = "user_id")
    private Long userId;

    @SerializedName(value = "meal_id")
    private Long mealId;
}
