package uz.jl.lunch_order_rest.dto.order;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import uz.jl.lunch_order_rest.dto.BaseDto;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreateDto implements BaseDto {
    private LocalDateTime date;

    @SerializedName(value = "user_by")
    private Long userId;

    @SerializedName(value = "meal_by")
    private Long mealId;

    @SerializedName(value = "created_by")
    private Long createdBy;
}
